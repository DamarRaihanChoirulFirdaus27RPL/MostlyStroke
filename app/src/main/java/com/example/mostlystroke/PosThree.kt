package com.example.mostlystroke

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.zxing.Result
import kotlinx.android.synthetic.main.activity_absen.*
import me.dm7.barcodescanner.core.IViewFinder
import me.dm7.barcodescanner.zxing.ZXingScannerView

class PosThree : AppCompatActivity(), ZXingScannerView.ResultHandler, View.OnClickListener {
    private lateinit var mScanView: ZXingScannerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pos_three)
        initItem()
        defaultView()
        btn_reset.setOnClickListener(this)
    }

    private fun initItem() {
        mScanView = object : ZXingScannerView(this) {
            override fun createViewFinderView(context: Context): IViewFinder {
                return CustomView(context)
            }
        }
        mScanView.setAutoFocus(true)
        mScanView.setResultHandler(this)
        frame_layout.addView(mScanView)
    }

    private fun reqPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(Manifest.permission.CAMERA), 100)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            100 -> {
                initItem()
            }
            else -> {

            }
        }
    }

    override fun onPause() {
        mScanView.stopCamera()
        super.onPause()
    }

    override fun onStart() {
        mScanView.startCamera()
        reqPermissions()
        super.onStart()
    }

    private fun defaultView() {
        btn_reset.visibility = View.GONE
    }

    override fun handleResult(rawResult: Result?) {
        tv_code_value.text = rawResult?.text
        btn_reset.visibility = View.VISIBLE
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_reset -> {
                mScanView.resumeCameraPreview(this)
                defaultView()
            }
            else -> {

            }
        }
    }
}
