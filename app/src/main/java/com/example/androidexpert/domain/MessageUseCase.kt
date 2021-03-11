package com.example.androidexpert.domain

interface MessageUseCase {
    fun getMessage(name: String) : MessageEntity
}