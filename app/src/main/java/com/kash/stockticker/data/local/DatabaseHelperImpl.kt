package com.kash.stockticker.data.local

import com.kash.stockticker.data.local.entity.DataStock

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getUsers(): List<DataStock> = appDatabase.userDao().getAll()

    override suspend fun insertAll(users: List<DataStock>) = appDatabase.userDao().insertAll(users)

}