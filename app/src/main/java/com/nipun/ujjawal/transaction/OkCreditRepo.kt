package com.nipun.ujjawal.transaction

import androidx.lifecycle.LiveData
import com.nipun.okcredit.Data.local.CustomerEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OkCreditRepo(val okCreditDAO: UjjwalDAO) {
    fun addNewCustomer(customerEntity: CustomerEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            okCreditDAO.addNewCustomer(customerEntity)
        }
    }

    fun getCustomerList(): LiveData<List<CustomerEntity>> {
        return okCreditDAO.getCustomersList()
    }

    fun getCustomer(name: String): LiveData<List<CustomerEntity>> {
        return okCreditDAO.getCustomer(name)
    }


}