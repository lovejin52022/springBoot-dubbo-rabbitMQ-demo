package com.zengjin.common.restful.response

data class GenericPageableResponse<T>(
        var code: Int = 0,
        var message: String = "",
        var items: List<T> = listOf(),
        var totalPages: Int = 0,
        var totalElements: Long = 0,
        var currentPage: Int = 0,
        var pageSize: Int = 0
)