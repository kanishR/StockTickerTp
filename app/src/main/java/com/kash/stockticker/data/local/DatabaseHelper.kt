package com.kash.stockticker.data.local

import com.kash.stockticker.data.local.entity.DataStock

interface DatabaseHelper {

    suspend fun getUsers(): List<DataStock>

    suspend fun insertAll(users: List<DataStock>)

}