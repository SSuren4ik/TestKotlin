package com.example.testprojectusecase.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testprojectusecase.R
import com.example.testprojectusecase.data.repository.UserRepositoryImpl
import com.example.testprojectusecase.domain.models.SaveUserNameParam
import com.example.testprojectusecase.domain.usecase.GetUserNameUseCase
import com.example.testprojectusecase.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            applicationContext
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val receiveButton = findViewById<Button>(R.id.receiveButton)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val param = SaveUserNameParam(text, "last_name")
            val result = saveUserNameUseCase.execute(param)
            dataTextView.text = "Saved result is $result"
        }

        receiveButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }


    }
}