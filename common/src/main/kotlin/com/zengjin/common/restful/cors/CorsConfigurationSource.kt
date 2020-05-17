package com.zengjin.common.restful.cors

import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import javax.servlet.http.HttpServletRequest

class CorsConfigurationSource(
        private val allowedOrigins: Array<String>
) : CorsConfigurationSource {

    private val configuration = this.build()

    private fun build(): CorsConfiguration {
        val conf = CorsConfiguration()
        conf.allowedHeaders = listOf(
                "Origin",
                "Content-Type",
                "Authorization",
                "Accept",
                "X-Requested-With"
        )
        conf.allowedMethods = listOf(
                "GET",
                "HEAD",
                "POST",
                "PUT",
                "PATCH",
                "DELETE",
                "OPTIONS",
                "TRACE"
        )
        conf.allowedOrigins = this.allowedOrigins.toList()
        return conf
    }

    override fun getCorsConfiguration(request: HttpServletRequest): CorsConfiguration {
        return this.configuration
    }
}