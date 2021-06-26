package com.nipun.ujjawal.transaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CustomerViewModelFactory(val repository: OkCreditRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return CustomerViewModel(repository) as T
    }
}