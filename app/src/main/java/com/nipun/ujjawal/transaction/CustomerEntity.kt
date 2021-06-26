package com.nipun.okcredit.Data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customerEntity")
data class CustomerEntity(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "location") var location: String,
    @ColumnInfo(name = "businessname") var businessname: String,
    @ColumnInfo(name = "commodity") var commoditity: String,

) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null


}