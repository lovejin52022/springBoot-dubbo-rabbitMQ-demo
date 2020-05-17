package com.zengjin.admin

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */

@SpringBootApplication(scanBasePackages = ["com.zengjin.admin"])
@EnableDubboConfiguration
class ServerApplication

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}
