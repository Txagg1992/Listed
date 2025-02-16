package com.curiousapps.listed.data

import com.curiousapps.listed.domain.ListIdItem
import com.curiousapps.listed.domain.ListIdRepository
import com.curiousapps.listed.network.ListedApi
import okio.IOException
import javax.inject.Inject

class ListIdRepositoryImpl @Inject constructor(
    private val api: ListedApi
): ListIdRepository {
    override suspend fun fetchListIds(): Result<List<ListIdItem>> {
        try {
            api.fetchListIds().let {
                return Result.success(it)
            }
        }catch (e: IOException){
            return Result.failure(e)
        }
    }
}