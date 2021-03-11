package com.example.androidexpert.di

import com.example.androidexpert.data.IMessageDataSource
import com.example.androidexpert.data.MessageDataSource
import com.example.androidexpert.data.MessageRepository
import com.example.androidexpert.domain.IMessageRepository
import com.example.androidexpert.domain.MessageInteractor
import com.example.androidexpert.domain.MessageUseCase

object Injection {
    fun provideUseCase() : MessageUseCase {
        val messageRepository = provideRepository()
        return MessageInteractor(messageRepository)
    }

    private fun provideRepository(): IMessageRepository {
        val messageDataSource = provideDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideDataSource(): IMessageDataSource {
        return MessageDataSource()
    }
}