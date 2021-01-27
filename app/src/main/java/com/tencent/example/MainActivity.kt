package com.tencent.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
private val url="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUtSmHmRFAXGeNxDekhktVrcA8X0hVvUHFHQ&usqp=CAU"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun load(view: View) {
        glideImageView.load(url)
    }
}
