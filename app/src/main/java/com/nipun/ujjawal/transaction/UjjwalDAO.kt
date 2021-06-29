package com.nipun.ujjawal.transaction

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nipun.ujjawal.hp.local.UserEntity
import com.nipun.okcredit.Data.local.CustomerEntity

@Dao
interface UjjwalDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewCustomer(customerEntity: CustomerEntity)

    @Query("select * from customerentity ")
    fun getCustomersList(): LiveData<List<CustomerEntity>>

    @Query("select * from customerentity where name=:newName")
    fun getCustomer(newName: String): LiveData<List<CustomerEntity>>

    //
    @Insert
    fun addNewUser(entity: UserEntity)

    @Query("select * from Users")
    fun fetchUser(): LiveData<List<UserEntity>>

    @Query("select * from Users where UserType = :supplier")
    fun fetchAllSuppliers(supplier:String): LiveData<List<UserEntity>>

    @Update
    fun updateUser(usersEntity: UserEntity)

    @Query("select * from Users where UserMobNo =:mobileNo")
    fun fetchParticularUser(mobileNo:String): UserEntity

}
