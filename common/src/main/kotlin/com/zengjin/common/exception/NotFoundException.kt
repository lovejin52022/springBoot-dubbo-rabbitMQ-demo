package com.zengjin.common.exception

import org.springframework.http.HttpStatus

/**
 * @desc
 * @author zengjin
 * @date 2020/5/14
 */
class NotFoundException(
        message: String
) : APIRuntimeException(
        errCode = 404,
        httpStatus = HttpStatus.NOT_FOUND,
        message = message
)