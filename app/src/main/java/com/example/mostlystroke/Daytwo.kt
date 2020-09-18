package com.example.mostlystroke

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Daytwo : AppCompatActivity() {
    private lateinit var btnstart: ImageButton
    private lateinit var btnpos1: ImageButton
    private lateinit var btnpos2: ImageButton
    private lateinit var btnpos3: ImageButton
    private lateinit var btnfinish: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daytwo)
        btnstart = findViewById(R.id.btn_start)
        btnstart.setOnClickListener{
            startActivity(Intent(this, PosStart::class.java))
        }
        btnpos1 = findViewById(R.id.btn_pos1)
        btnpos1.setOnClickListener{
            startActivity(Intent(this, PosOne::class.java))
        }
        btnpos2 = findViewById(R.id.btn_pos2)
        btnpos2.setOnClickListener{
            startActivity(Intent(this, PosTwo::class.java))
        }
        btnpos3 = findViewById(R.id.btn_pos3)
        btnpos3.setOnClickListener{
            startActivity(Intent(this, PosThree::class.java))
        }
        btnfinish = findViewById(R.id.btn_finish)
        btnfinish.setOnClickListener{
            startActivity(Intent(this, PosFinish::class.java))
        }
    }
}
