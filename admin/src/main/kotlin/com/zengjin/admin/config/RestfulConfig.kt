package com.zengjin.admin.config

import com.zengjin.common.restful.WebSecurityConfigurerAdapter
import com.zengjin.common.restful.cors.CorsFilter
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */
@Component
class RestfulConfig {
    @Bean(name = ["corsFilter"])
    fun corsFilter() = CorsFilter(allowedOrigins = arrayOf("*"))

    @Bean
    fun webSecurityConfigAdapter() = WebSecurityConfigurerAdapter()
}