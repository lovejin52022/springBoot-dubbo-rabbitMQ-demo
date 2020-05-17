package com.zengjin.common.restful.cors

import org.springframework.web.filter.CorsFilter

class CorsFilter(
        allowedOrigins: Array<String>
) : CorsFilter(CorsConfigurationSource(allowedOrigins = allowedOrigins))