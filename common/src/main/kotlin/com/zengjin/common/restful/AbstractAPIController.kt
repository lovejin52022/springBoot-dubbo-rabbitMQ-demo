package com.zengjin.common.restful

import com.zengjin.common.exception.APIRuntimeException
import com.zengjin.common.exception.BadRequestException
import com.zengjin.common.restful.response.GenericResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

abstract class AbstractAPIController {

    @ExceptionHandler
    fun exceptionHandler(throwable: Throwable, request: HttpServletRequest, response: HttpServletResponse): GenericResponse<String> {
        return if (throwable is APIRuntimeException) {
            response.status = throwable.httpStatus.value()
            GenericResponse(
                    code = throwable.errCode,
                    message = throwable.message ?: "服务器内部错误"
            )
        } else {
            response.status = 422
            GenericResponse(
                    code = 422,
                    message = throwable.message ?: throwable.cause?.message ?: "服务器内部错误"
            )
        }
    }

    companion object {
        const val TOKEN_HEADER = "Authorization"
        const val TOKEN_STARTS = "Bearer "
    }

    protected fun trimToken(token: String) = when {
        !token.startsWith(TOKEN_STARTS) -> throw BadRequestException("token需要${TOKEN_STARTS}开头")
        token == TOKEN_STARTS -> throw BadRequestException("token为空")
        else -> token.substring(TOKEN_STARTS.length)
    }

    protected fun getToken(): String? {
        val servletRequestAttributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val request = servletRequestAttributes.request
        val token = request.getHeader(TOKEN_HEADER)
        return token?.let { this.trimToken(it) }
    }

}