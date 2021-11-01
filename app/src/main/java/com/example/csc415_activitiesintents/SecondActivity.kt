package com.example.csc415_activitiesintents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

val EXTRA_REPLY: String = "com.example.android.CSC415-ActivitiesIntents.extra.REPLY"

class SecondActivity : AppCompatActivity() {
    private lateinit var mReply: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent: Intent = getIntent()
        val message: String? = intent.getStringExtra(EXTRA_MESSAGE)
        val textView: TextView = findViewById(R.id.text_message)
        textView.setText(message)
        mReply = findViewById(R.id.editText_second)
    }

    fun returnReply(view: View?) {
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, mReply.text.toString())
        setResult(RESULT_OK, replyIntent)
        finish()
    }

}