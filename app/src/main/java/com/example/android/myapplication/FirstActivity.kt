package com.example.android.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText


class FirstActivity : AppCompatActivity() {


    private lateinit var btnAuthorizationOrder: Button
    private lateinit var edPhoneNumberOrder: EditText
    private lateinit var btnClose: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        btnAuthorizationOrder = findViewById<Button>(R.id.btnAuthorization)
        edPhoneNumberOrder = findViewById<EditText>(R.id.edPhoneNumber)
        btnAuthorizationOrder.setOnClickListener {
            SecondActivity.newInstance(this, edPhoneNumberOrder.text.toString())
        }

    }

    fun onClickCLose(view: View) {
        btnClose = findViewById<Button>(R.id.btnBack)
        finish()
    }
}



