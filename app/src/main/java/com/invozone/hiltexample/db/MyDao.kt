package com.invozone.hiltexample.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.invozone.hiltexample.models.QuoteList
import com.invozone.hiltexample.models.Result

@Dao
interface MyDao {
    // insert into database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products: List<Result>)

    // fetch all record from the database
    @Query("SELECT * FROM Result")
    suspend fun getProducts() : List<Result>

    @Query("SELECT * FROM Result WHERE _id = :id")
    suspend fun getOneProduct(id: Int) : List<Result>
}