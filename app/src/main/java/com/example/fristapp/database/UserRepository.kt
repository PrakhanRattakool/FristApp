package com.example.firstapp.Data
import androidx.lifecycle.LiveData
import com.example.fristapp.database.User
import com.example.fristapp.database.UserDao

class UserRepository (private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()
    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}