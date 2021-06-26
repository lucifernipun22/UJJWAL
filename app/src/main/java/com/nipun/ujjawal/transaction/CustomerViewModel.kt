package com.nipun.ujjawal.transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nipun.okcredit.Data.local.CustomerEntity


class CustomerViewModel(val repository: OkCreditRepo) : ViewModel() {

    fun addNewCustomer(customerEntity: CustomerEntity) {
        repository.addNewCustomer(customerEntity)
    }

    fun getCustomerList(): LiveData<List<CustomerEntity>> {
        return repository.getCustomerList()
    }

    fun customerDetails(name: String): LiveData<List<CustomerEntity>> {
        return repository.getCustomer(name)
    }



}