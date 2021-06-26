package com.nipun.ujjawal.transaction

import com.nipun.okcredit.Data.local.CustomerEntity

interface OnRowItemClicked {
    fun onItemClick( model: CustomerEntity)


}