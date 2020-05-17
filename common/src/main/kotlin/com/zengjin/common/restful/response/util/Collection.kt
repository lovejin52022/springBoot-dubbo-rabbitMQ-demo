package com.zengjin.common.restful.response.util

import com.zengjin.common.restful.response.GenericPageableResponse

fun <T> Collection<T>.toPageableResponse(): GenericPageableResponse<T> {
    return GenericPageableResponse(
            items = this.toList(),
            totalElements = this.size.toLong(),
            totalPages = 1,
            currentPage = 0,
            pageSize = Int.MAX_VALUE
    )
}