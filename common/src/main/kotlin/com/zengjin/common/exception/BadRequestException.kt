package com.zengjin.common.exception

import org.springframework.http.HttpStatus

/**
 * @desc
 * @author zengjin
 * @date 2020/5/14
 */
class BadRequestException(
        message: String = "请求参数不合法"
) : APIRuntimeException(
        errCode = 400,
        httpStatus = HttpStatus.BAD_REQUEST,
        message = message
)