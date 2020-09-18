package com.example.mostlystroke

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var btnlogo: ImageButton
    private lateinit var btnabsen: ImageButton
    private lateinit var btnsouvenir: ImageButton
    private lateinit var btndayone: ImageButton
    private lateinit var btndaytwo: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnlogo = findViewById(R.id.btn_logo)
        btnlogo.setOnClickListener{
            startActivity(Intent(this, Information::class.java))
        }
        btnabsen = findViewById(R.id.btn_absen)
        btnabsen.setOnClickListener{
            startActivity(Intent(this, Absen::class.java))
        }
        btnsouvenir = findViewById(R.id.btn_souvenir)
        btnsouvenir.setOnClickListener{
            startActivity(Intent(this, Souvenir::class.java))
        }
        btndayone = findViewById(R.id.btn_dayone)
        btndayone.setOnClickListener{
            startActivity(Intent(this, Dayone::class.java))
        }
        btndaytwo = findViewById(R.id.btn_daytwo)
        btndaytwo.setOnClickListener{
            startActivity(Intent(this, Dayone::class.java))
        }

    }
}
