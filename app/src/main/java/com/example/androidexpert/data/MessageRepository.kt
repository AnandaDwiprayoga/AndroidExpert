package com.example.androidexpert.data

import com.example.androidexpert.domain.IMessageRepository
import com.example.androidexpert.domain.MessageEntity

class MessageRepository(private val messageDataSource: IMessageDataSource) : IMessageRepository {
    override fun getWelcomeMessage(name: String): MessageEntity =
        messageDataSource.getMessageFromSource(name)
}