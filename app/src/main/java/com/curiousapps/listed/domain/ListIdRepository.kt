package com.curiousapps.listed.domain

import dagger.hilt.android.scopes.ActivityScoped

@ActivityScoped
interface ListIdRepository {

    suspend fun fetchListIds(): Result<List<ListIdItem>>
}