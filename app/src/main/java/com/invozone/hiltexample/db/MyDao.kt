package com.invozone.hiltexample.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.invozone.hiltexample.models.Product

@Dao
interface MyDao {
    // insert into database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products: List<Product>)

    // fetch all record from the database
    @Query("SELECT * FROM Product")
    suspend fun getProducts() : List<Product>

    @Query("SELECT * FROM Product WHERE id = :id")
    suspend fun getOneProduct(id: Int) : Product
}