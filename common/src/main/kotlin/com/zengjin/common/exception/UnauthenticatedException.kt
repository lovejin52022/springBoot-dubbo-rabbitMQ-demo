package com.zengjin.common.exception

import org.springframework.http.HttpStatus

/**
 * @desc
 * @author zengjin
 * @date 2020/5/14
 */
class UnauthenticatedException(
        message: String = "用户权限不足"
) : APIRuntimeException(
        errCode = 403,
        httpStatus = HttpStatus.FORBIDDEN,
        message = message
)