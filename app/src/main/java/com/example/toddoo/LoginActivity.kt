package com.example.toddoo

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.toddoo.databinding.ActivityLoginBinding
import com.example.toddoo.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        }
    fun login(view:View){
        val userid = binding.editTextTextEmailAddress.text.toString()
        val passwd = binding.editTextNumberPassword.text.toString()
        if(userid == "1234"&& passwd =="0123"){
            getSharedPreferences("key", Context.MODE_PRIVATE)
                .edit()
                .apply()
            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show()
            val intent =  Intent (this, ListActivity::class.java)
            startActivity(intent)
        }
        else {
            AlertDialog.Builder(this)
                .setTitle("帳密有誤")
                .setMessage("登入失敗")
                .setPositiveButton("ok",null)
                .show()
        }
    }

}
