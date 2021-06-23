package com.example.aboutme

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = MyName(getString(R.string.main_info_owner_name))

        binding.buttonDone.setOnClickListener {
            addNickname()
        }
    }

    private fun addNickname() {
        binding.apply {
            myName?.nickname = editNickname.text.toString()
            invalidateAll()
            editNickname.visibility = View.GONE
            buttonDone.visibility = View.GONE
            textNickname.visibility = View.VISIBLE
        }

        CustomSystemService.hideKeyboard(applicationContext, binding.editNickname)
    }
}