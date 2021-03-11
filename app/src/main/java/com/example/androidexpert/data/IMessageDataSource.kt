package com.example.androidexpert.data

import com.example.androidexpert.domain.MessageEntity

interface IMessageDataSource {
    fun getMessageFromSource(name: String): MessageEntity
}