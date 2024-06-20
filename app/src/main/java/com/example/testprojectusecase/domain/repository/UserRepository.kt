package com.example.testprojectusecase.domain.repository

import com.example.testprojectusecase.domain.models.SaveUserNameParam
import com.example.testprojectusecase.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}