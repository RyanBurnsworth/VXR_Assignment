package com.ryanburnsworth.vxrassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("SENTENCE", "DATA: " + generateRandomString())
    }

    private external fun generateRandomString(): String

    companion object {
        init {
            System.loadLibrary("vxrlib")
        }
    }
}
