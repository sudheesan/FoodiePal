package com.miu.foodiepal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.miu.foodiepal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var spf: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        spf = getSharedPreferences("login", Context.MODE_PRIVATE)
        val uName = spf.getString("uName", "")
        val pwd = spf.getString("pwd", "")

        binding.loginEmail.setText(uName)
        binding.loginPassword.setText(pwd)

        binding.buttonRegister.setOnClickListener {
            val registerIntent = Intent(this, RegisterPage::class.java)
            startActivity(registerIntent)
        }

        binding.buttonLogin.setOnClickListener {
            val userName = binding.loginEmail.text.toString()
            val password = binding.loginPassword.text.toString()

            if(userName.isNotEmpty() && password.isNotEmpty()){
                val validUName = spf.getString("uName", "")
                val validPwd = spf.getString("pwd", "")

                if(validUName.equals(userName) && validPwd.equals(password)){
                    val landingPageIntent = Intent(this, LandingPage::class.java)
                    startActivity(landingPageIntent)
                }else{
                    Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG).show()
                }

            } else{
                Toast.makeText(this, "Please provide credentials.", Toast.LENGTH_LONG).show()
            }
        }
    }
}