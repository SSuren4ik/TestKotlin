package com.example.testprojectusecase.domain.usecase

import com.example.testprojectusecase.domain.models.UserName
import com.example.testprojectusecase.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}