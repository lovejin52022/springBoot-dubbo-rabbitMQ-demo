package com.zengjin.service

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import tk.mybatis.spring.annotation.MapperScan

/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */
@SpringBootApplication(scanBasePackages = ["com.zengjin.service"])
@MapperScan(basePackages = ["com.zengjin.service.persistence.mapper"])
@EnableDubboConfiguration
class ServerApplication

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}