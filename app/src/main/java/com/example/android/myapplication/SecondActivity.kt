package com.example.android.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class SecondActivity : AppCompatActivity() {
    companion object {
        private const val KEY_NUMBER = "PhoneNumber"
        private const val TEXT_PROMT = "Конт.номер-"
        fun newInstance(activity: Activity, PhoneNumber: String) {
            val phoneNumberClient = Intent(activity, SecondActivity::class.java).apply {
                putExtra(KEY_NUMBER, PhoneNumber)
            }
            activity.startActivity(phoneNumberClient)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val edTextComment = findViewById<TextView>(R.id.edComment)
        edTextComment.text = TEXT_PROMT + intent.getStringExtra(KEY_NUMBER)

    }
}