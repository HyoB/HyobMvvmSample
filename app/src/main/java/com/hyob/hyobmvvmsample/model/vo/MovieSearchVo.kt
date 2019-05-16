package com.hyob.hyobmvvmsample.model.vo

import com.google.gson.annotations.SerializedName
import java.util.*

data class MovieSearchVo(
    @SerializedName("lastBuildDate") val lastBuildDate: String,
    @SerializedName("total") val total: Int,
    @SerializedName("start") val start: Int,
    @SerializedName("display") val display: Int,
    @SerializedName("items") val movies: List<MovieVo>

)