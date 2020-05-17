package com.zengjin.common.restful

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

class WebSecurityConfigurerAdapter(
        private val csrfExclude: Array<String> = arrayOf("api/**/*"),
        private val corsInclude: Array<String> = arrayOf("api/**/*"),
        private val basicAuthExclude: Array<String> = arrayOf("**/*")
) : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        this.csrfExclude.forEach {
            http.antMatcher(it).csrf().disable()
        }
        this.corsInclude.forEach {
            http.antMatcher(it).cors()
        }
        this.basicAuthExclude.forEach {
            http.antMatcher(it).authorizeRequests().anyRequest().permitAll()
        }
    }
}