package com.example.testprojectusecase.data.storage

import com.example.testprojectusecase.domain.models.SaveUserNameParam
import com.example.testprojectusecase.domain.models.UserName

interface UserStorage {

    fun save(saveParam: SaveUserNameParam): Boolean

    fun get(): UserName
}