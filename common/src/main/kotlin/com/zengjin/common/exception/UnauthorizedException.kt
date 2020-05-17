package com.zengjin.common.exception

import org.springframework.http.HttpStatus

/**
 * @desc
 * @author zengjin
 * @date 2020/5/14
 */
class UnauthorizedException(
        message: String = "用户未登录"
) : APIRuntimeException(
        errCode = 401,
        httpStatus = HttpStatus.UNAUTHORIZED,
        message = message
)