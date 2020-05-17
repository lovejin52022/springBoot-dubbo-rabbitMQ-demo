package com.zengjin.common.restful.response

class GenericResponse<T>(
        var code: Int = 0,
        var message: String = "",
        var items: T? = null
)