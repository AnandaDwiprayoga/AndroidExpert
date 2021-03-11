package com.example.androidexpert.domain

interface IMessageRepository {
    fun getWelcomeMessage(name: String): MessageEntity
}