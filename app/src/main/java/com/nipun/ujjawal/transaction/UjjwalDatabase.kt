package com.nipun.ujjawal.transaction

import android.content.Context
import androidx.room.*
import com.nipun.okcredit.Data.local.CustomerEntity


@Database(entities = [CustomerEntity::class], version = 1,exportSchema = false)
@TypeConverters(value = [CustomerConverter::class])
abstract class UjjwalDatabase : RoomDatabase() {

    abstract fun getOkCreditDao(): UjjwalDAO

    companion object {

        private var INSTANCE: UjjwalDatabase? = null

        fun getRoomDatabase(context: Context): UjjwalDatabase {

            if (INSTANCE == null) {

                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    UjjwalDatabase::class.java,
                    "OkCredit_database"
                )

                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }

        }

    }
}