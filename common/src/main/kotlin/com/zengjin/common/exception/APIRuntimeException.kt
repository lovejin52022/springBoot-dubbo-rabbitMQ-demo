package com.zengjin.common.exception

import org.springframework.http.HttpStatus

/**
 * @desc
 * @author zengjin
 * @date 2020/5/14
 */
open class APIRuntimeException : RuntimeException {

    var errCode = 500

    var httpStatus = HttpStatus.UNPROCESSABLE_ENTITY

    constructor(e: Throwable) : super(e)

    constructor(message: String) : super(message)

    constructor() : super()

    constructor(message: String, errCode: Int) : super(message) {
        this.errCode = errCode
    }

    constructor(message: String, errCode: Int, httpStatus: HttpStatus) : super(message) {
        this.errCode = errCode
        this.httpStatus = httpStatus
    }

    constructor(message: String, httpStatus: HttpStatus) : super(message) {
        this.errCode = httpStatus.value()
        this.httpStatus = httpStatus
    }
}