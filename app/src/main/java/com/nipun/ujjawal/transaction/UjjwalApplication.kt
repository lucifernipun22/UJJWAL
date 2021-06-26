package com.nipun.ujjawal.transaction

import android.app.Application

class UjjwalApplication : Application() {

    val okCreditDAO by lazy {
        val roomDatabase = UjjwalDatabase.getRoomDatabase(this)
        roomDatabase.getOkCreditDao()
    }

    //repositoy which is responsible for getting the data and returning to viewmodel
    val repository by lazy {
        OkCreditRepo(okCreditDAO)
    }


}