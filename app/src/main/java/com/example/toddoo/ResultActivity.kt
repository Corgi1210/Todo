package com.example.toddoo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.toddoo.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val bt = binding.button
        bt.setOnClickListener {
            val todoText = binding.TextToDo.text.toString()
            val intent = Intent()
            intent.putExtra("todo", todoText)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}