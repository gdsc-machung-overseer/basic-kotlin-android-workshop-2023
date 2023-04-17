package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var username = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initView()
    }

    private fun initView() {
        binding.btnLogin.setOnClickListener {
            if(login()) { //kalau password benar
                var intent = Intent(this, HomeActivity::class.java) //ingin ke homeActivity
                intent.putExtra("nama", username)//tambahkan variabel nama
                this.startActivity(intent)//ke HomeActivity
            }
        }
    }

    private fun login():Boolean {
        val password = "123"

        val validPassword: Boolean = binding.etPassword.text.toString() == password
        username = binding.etUsername.text.toString()

        return validPassword
    }


}

