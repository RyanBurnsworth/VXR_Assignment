package com.ryanburnsworth.vxrassignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randomWordListArray = arrayListOf<String>()
        val recyclerView = recycler_view
        val adapter = RandomWordListAdapter(randomWordListArray)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
        button_string_generator.setOnClickListener {
            val randomSentence = generateRandomString()
            randomWordListArray.add(randomSentence)
            adapter.updateWordList(randomWordListArray)
            recyclerView.scrollToPosition(randomWordListArray.size - 1)
        }
    }

    private external fun generateRandomString(): String

    companion object {
        init {
            System.loadLibrary("vxrlib")
        }
    }
}
