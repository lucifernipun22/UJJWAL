package com.nipun.ujjawal.news


import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("category")
    var category: String? = null,
    @SerializedName("data")
    var `data`: List<Data>? = null,
    @SerializedName("success")
    var success: Boolean? = null
)