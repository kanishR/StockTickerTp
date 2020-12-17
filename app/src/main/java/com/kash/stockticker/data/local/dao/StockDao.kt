package com.kash.stockticker.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kash.stockticker.data.local.entity.DataStock

@Dao
interface StockDao {

    @Query("SELECT * FROM DataStock")
    suspend fun getAll(): List<DataStock>

    @Insert
    suspend fun insertAll(stocks: List<DataStock>)

    @Delete
    suspend fun delete(stock: DataStock)

}