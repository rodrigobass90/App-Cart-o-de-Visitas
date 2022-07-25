package com.rodrigo.businesscard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
Import androidx.room.Query

@dao
interface BusinessCardDao {

    @Query(value: "SELECT * FROM BusinessCard")
    fun getAll (): LiveData<List<BusinessCard>>

    @Insert(OnConflict = onConflictStrategy.IGNORE)
    suspend fun insert(businessCard: BusinessCard)

}