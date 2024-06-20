package com.example.testprojectusecase.data.repository

import com.example.testprojectusecase.domain.models.SaveUserNameParam
import com.example.testprojectusecase.domain.models.UserName
import com.example.testprojectusecase.domain.repository.UserRepository




class UserRepositoryImpl() : UserRepository {


    override fun saveName(saveParam: SaveUserNameParam): Boolean {

    }

    override fun getName(): UserName {

    }
}