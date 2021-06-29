package com.nipun.ujjawal.news



import com.example.ujjwala.remote.RetrofitGenerator
import com.nipun.ujjawal.transaction.UjjwalDAO


class UjjwalRepo(val okCreditDAO: UjjwalDAO) {

    val api = RetrofitGenerator.getInstance().create(ApiService::class.java)



    suspend fun getAgreeNews(agri: String): List<Data>? {
        var nList = api.getAgriNews(agri)
        return nList!!.data!!
    }



}