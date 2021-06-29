package com.nipun.ujjawal.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nipun.ujjawal.transaction.CustomerViewModel
import com.nipun.ujjawal.transaction.OkCreditRepo
import com.nipun.ujjawal.transaction.UjjwalDAO

class UjjwalFactory(val repository: UjjwalDAO) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return UjjwalViewModel(repository) as T
    }
}