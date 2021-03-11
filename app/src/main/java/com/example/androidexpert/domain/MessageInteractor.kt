package com.example.androidexpert.domain

class MessageInteractor(private val messageRepository: IMessageRepository): MessageUseCase {
    override fun getMessage(name: String): MessageEntity {
       return messageRepository.getWelcomeMessage(name)
    }
}