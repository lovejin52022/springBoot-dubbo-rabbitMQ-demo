package com.zengjin.admin.config

import com.google.common.base.Predicate
import com.google.common.base.Predicates
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.ResponseEntity
import org.springframework.web.context.request.async.DeferredResult
import springfox.documentation.builders.PathSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.HashSet

/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */

@Configuration
@EnableSwagger2
class SwaggerConfig {

    private val version = "v1"

    @Bean
    fun userApi(): Docket {
        return this.docket("demo", "demo测试API", Predicates.or(PathSelectors.regex("/api/v1/demo/.*")))
    }

    protected fun docket(title: String, desc: String, paths: Predicate<String>): Docket {
        val info = ApiInfo(
                title,
                desc,
                this.version,
                "NO terms of service",
                Contact("zengjin", "", "lovejin52022@gmail.com"),
                "The Apache License, Version 2.0", //链接显示文字
                "http://www.apache.org/licenses/LICENSE-2.0.html", //网站链接
                listOf()
        )
        return Docket(DocumentationType.SWAGGER_2)
                .groupName(title)
                .genericModelSubstitutes(DeferredResult::class.java)
                .genericModelSubstitutes(ResponseEntity::class.java)
                .produces(object : HashSet<String>() {
                    init {
                        add("application/json")
                    }
                })
                .useDefaultResponseMessages(false)
                //.globalOperationParameters(listOf(this.globalAuthHeader()))
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(paths)//过滤的接口
                .build()
                .apiInfo(info)
    }
}