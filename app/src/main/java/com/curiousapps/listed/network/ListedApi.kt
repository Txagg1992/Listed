package com.curiousapps.listed.network

import com.curiousapps.listed.domain.ListIdItem
import com.curiousapps.listed.util.URL_EXT
import retrofit2.http.GET

interface ListedApi {

    @GET(URL_EXT)
    suspend fun fetchListIds(): List<ListIdItem>
}