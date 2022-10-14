package com.invozone.hiltexample.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.invozone.hiltexample.models.Product

@Database(entities = [Product::class], version = 1)
abstract class MyDb() : RoomDatabase(){

    abstract fun getDao() : MyDao
}