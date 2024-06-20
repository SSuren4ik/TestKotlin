package com.example.testprojectusecase.domain.usecase

import com.example.testprojectusecase.domain.models.SaveUserNameParam
import com.example.testprojectusecase.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val oldUserName = userRepository.getName()
        if (oldUserName.firstName == param.firstName)
            return true

        return userRepository.saveName(param)
    }
}