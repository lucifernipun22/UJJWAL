package com.nipun.ujjawal.transaction

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nipun.okcredit.Data.local.CustomerEntity

@Dao
interface UjjwalDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewCustomer(customerEntity: CustomerEntity)

    @Query("select * from customerentity ")
    fun getCustomersList(): LiveData<List<CustomerEntity>>

    @Query("select * from customerentity where name=:newName")
    fun getCustomer(newName: String): LiveData<List<CustomerEntity>>

}
