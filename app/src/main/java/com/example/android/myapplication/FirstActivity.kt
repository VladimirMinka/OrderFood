package com.example.android.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


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
        findViewById<View>(R.id.tv_skip).setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }

    }

    fun onClickCLose(view: View) {
        btnClose = findViewById<Button>(R.id.btnBack)
        finish()
    }
}



