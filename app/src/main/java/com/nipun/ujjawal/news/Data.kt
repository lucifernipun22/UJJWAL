package com.nipun.ujjawal.news


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("author")
    var author: String? = null,
    @SerializedName("content")
    var content: String? = null,
    @SerializedName("date")
    var date: String? = null,
    @SerializedName("imageUrl")
    var imageUrl: String? = null,
    @SerializedName("readMoreUrl")
    var readMoreUrl: String? = null,
    @SerializedName("time")
    var time: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("url")
    var url: String? = null
)