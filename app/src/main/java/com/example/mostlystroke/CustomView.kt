package com.example.mostlystroke

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import me.dm7.barcodescanner.core.ViewFinderView

class CustomView constructor(context: Context) : ViewFinderView(context) {
    private val paint = Paint()
    private val arrayScannerAlpha = intArrayOf(0, 64, 128, 192, 255, 192, 128, 64)
    private var scannerAlpha: Int = 0
    private var counter = 0
    private var goingup = false
    private val pointSize = 10
    private val animDelay = 80L

    init {
        paint.color = Color.WHITE
        paint.isAntiAlias = true
        setSquareViewFinder(true)
        setBorderColor(Color.parseColor("#35B781"))
        setLaserColor(Color.parseColor("#35B781"))
        setLaserEnabled(true)
    }

    override fun drawLaser(canvas: Canvas?) {
        paint.alpha = arrayScannerAlpha[scannerAlpha]
        scannerAlpha = (scannerAlpha + 1) % arrayScannerAlpha.size
        var middle = framingRect.height() / 2 + framingRect.top
        middle += counter
        if (counter < framingRect.top - mBorderLineLength - 10 && !goingup) {
            canvas?.drawRect(
                (framingRect.left + 2).toFloat(),
                (middle - 1).toFloat(),
                (framingRect.right - 1).toFloat(),
                (middle + 2).toFloat(),
                mLaserPaint
            )
            counter += 4
        }

        if (counter >= framingRect.top - mBorderLineLength - 10 && !goingup)
            goingup = true
        if (counter > -framingRect.top + mBorderLineLength + 10 && goingup) {
            canvas?.drawRect(
                (framingRect.left + 2).toFloat(),
                (middle - 1).toFloat(),
                (framingRect.right - 1).toFloat(),
                (middle + 2).toFloat(),
                mLaserPaint
            )
            counter -= 4
        }
        if (counter <= -framingRect.top + mBorderLineLength + 10 && goingup)
            goingup = false

        postInvalidateDelayed(
            animDelay,
            framingRect.left - pointSize,
            framingRect.top - pointSize,
            framingRect.right + pointSize,
            framingRect.bottom + pointSize
        )

    }
}