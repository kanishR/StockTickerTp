package com.kash.stockticker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kash.stockticker.data.local.dao.StockDao
import com.kash.stockticker.data.local.entity.DataStock

@Database(entities = [DataStock::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): StockDao

}