package com.nipun.ujjawal.news



import androidx.lifecycle.ViewModel

import com.nipun.ujjawal.news.Data
import com.nipun.ujjawal.news.UjjwalRepo
import com.nipun.ujjawal.transaction.UjjwalDAO


class UjjwalViewModel(val repository: UjjwalDAO) : ViewModel() {


    val ujjwalRepo = UjjwalRepo(repository)

    //agriculture
    suspend fun getAgreeNews(agri: String): List<Data>? {
        return ujjwalRepo.getAgreeNews(agri)
    }




}