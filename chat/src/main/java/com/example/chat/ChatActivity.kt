package com.example.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chat.databinding.ActivityChatBinding
import com.example.core.SessionManager
import com.example.core.UserRepository

class ChatActivity : AppCompatActivity() {
    private lateinit var activityChatBinding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityChatBinding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(activityChatBinding.root)

        val sesi = SessionManager(this)
        val userRepository = UserRepository.getInstance(sesi)
        activityChatBinding.tvChat.text = "Hello ${userRepository.getUser()}! \n Welcome to Chat Feature"
    }
}