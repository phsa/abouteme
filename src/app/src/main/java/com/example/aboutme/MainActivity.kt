package com.example.aboutme

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.buttonDone.setOnClickListener {
            addNickname()
        }
    }

    private fun addNickname() {
        viewBinding.textNickname.text = viewBinding.editNickname.text.toString()
        viewBinding.editNickname.visibility = View.GONE
        viewBinding.buttonDone.visibility = View.GONE
        viewBinding.textNickname.visibility = View.VISIBLE

        CustomSystemService.hideKeyboard(applicationContext, viewBinding.editNickname)
    }
}