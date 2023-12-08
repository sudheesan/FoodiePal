package com.miu.foodiepal

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.miu.foodiepal.databinding.ActivityRegisterPageBinding

class RegisterPage : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegister.setOnClickListener {

            val fName = binding.registerFName.text.toString()
            val lName = binding.registerLName.text.toString()
            val uName = binding.registerUserName.text.toString()
            val pwd = binding.editTextNumberPassword.text.toString()

            if(fName.isNotEmpty() && lName.isNotEmpty() && uName.isNotEmpty() && pwd.isNotEmpty()){
                val spf = getSharedPreferences("login", Context.MODE_PRIVATE)
                val spe = spf.edit()

                spe.putString("uName", uName)
                spe.putString("pwd", pwd)
                spe.putString("fName", fName)
                spe.putString("lName", lName)

                spe.apply()

                Toast.makeText(this, "Registered Successfully.", Toast.LENGTH_LONG).show()

                finish()

            } else{
                Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_LONG).show()
            }
        }
    }
}