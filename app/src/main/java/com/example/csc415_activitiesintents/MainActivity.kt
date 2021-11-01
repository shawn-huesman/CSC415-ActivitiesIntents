package com.example.csc415_activitiesintents

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.content.Intent
import android.view.View
import android.widget.EditText
import android.widget.TextView

const val EXTRA_MESSAGE = "example message"
val TEXT_REQUEST = 1

class MainActivity : AppCompatActivity() {
    private val LOG_TAG = MainActivity::class.java.simpleName
    private lateinit var mMessageEditText: EditText
    private lateinit var mReplyHeadTextView: TextView
    private lateinit var mReplyTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)

        if (savedInstanceState != null) {
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            if (isVisible) {
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = savedInstanceState
                    .getString("reply_text")
                mReplyTextView.visibility = View.VISIBLE
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if (mReplyHeadTextView.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text",
                mReplyTextView.getText().toString());
        }

    }


    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }


    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, mMessageEditText.text.toString());
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST)
        {
            if (resultCode == RESULT_OK)
            {
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = data!!.getStringExtra(EXTRA_REPLY)
                mReplyTextView.visibility = View.VISIBLE
            }
        }
    }

}