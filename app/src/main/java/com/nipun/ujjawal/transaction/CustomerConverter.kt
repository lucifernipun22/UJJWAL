package com.nipun.ujjawal.transaction

import androidx.room.TypeConverter
import com.google.gson.Gson

import com.nipun.okcredit.Data.local.CustomerEntity

class CustomerConverter {

    @TypeConverter
    fun listToJson(value: MutableList<CustomerEntity>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): MutableList<CustomerEntity>? {

        val objects =
            Gson().fromJson(value, Array<CustomerEntity>::class.java) as Array<CustomerEntity>
        return objects.toMutableList()
    }
}