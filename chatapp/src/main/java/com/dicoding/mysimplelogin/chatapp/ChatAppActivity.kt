package com.dicoding.mysimplelogin.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.mysimplelogin.chatapp.databinding.ActivityChatAppBinding
import com.example.core.SessionManager
import com.example.core.UserRepository

class ChatAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityChatAppBinding = ActivityChatAppBinding.inflate(layoutInflater)
        setContentView(activityChatAppBinding.root)

        val sesi = SessionManager(this)
        val userRepository = UserRepository.getInstance(sesi)
        activityChatAppBinding.tvChat.text = "Hello ${userRepository.getUser()}! \n Welcome to Chat Feature"
    }
}