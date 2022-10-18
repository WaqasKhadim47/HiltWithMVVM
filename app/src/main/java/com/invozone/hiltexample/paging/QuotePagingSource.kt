package com.invozone.hiltexample.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.invozone.hiltexample.models.Result
import com.invozone.hiltexample.retrofits.MyApi

class QuotePagingSource(val myApi: MyApi) : PagingSource<Int, Result>(){

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val position = params.key ?: 1
            val response = myApi.getQuotes(100)


            LoadResult.Page(
                data = response.body()!!.results,
                prevKey = if(position == 1) null else position - 1,
                nextKey = if(position ==  response.body()!!.totalPages) null else position + 1
            )
        }catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}