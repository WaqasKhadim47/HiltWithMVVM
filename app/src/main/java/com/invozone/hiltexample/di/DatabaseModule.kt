package com.invozone.hiltexample.di

import android.content.Context
import androidx.room.Room
import com.invozone.hiltexample.db.MyDao
import com.invozone.hiltexample.db.MyDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesMyDao (@ApplicationContext context: Context) : MyDb {
        return  Room.databaseBuilder(context, MyDb::class.java, "myDatabase")
            .fallbackToDestructiveMigration().build()
    }
}