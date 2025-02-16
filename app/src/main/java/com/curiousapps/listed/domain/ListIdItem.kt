package com.curiousapps.listed.domain


import com.google.gson.annotations.SerializedName

data class ListIdItem(
    @SerializedName("id")
    var id: Int,
    @SerializedName("listId")
    var listId: Int,
    @SerializedName("name")
    var name: String
)