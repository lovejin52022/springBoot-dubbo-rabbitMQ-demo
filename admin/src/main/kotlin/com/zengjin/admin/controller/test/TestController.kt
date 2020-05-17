package com.zengjin.admin.controller.test

import com.alibaba.dubbo.config.annotation.Reference
import com.zengjin.common.payload.User
import com.zengjin.common.restful.AbstractAPIController
import com.zengjin.common.restful.response.GenericPageableResponse
import com.zengjin.common.restful.response.GenericResponse
import com.zengjin.common.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */

@RestController
@RequestMapping("/api/v1/demo")
@Api(description = "demo测试", tags = ["demo测试"])
class TestController : AbstractAPIController() {

    // check false 不检查
    @Reference(version = "1.0.0", check = false)
    private lateinit var userService: UserService

    @GetMapping("hello")
    @ApiOperation(value = "测试")
    fun hello(): GenericResponse<String> {
        return GenericResponse(
                items = this.userService.sayHello("hello spring dubbo")
        )
    }

    @GetMapping("user")
    @ApiOperation(value = "测试返回用户数据")
    fun user(): GenericResponse<User> {
        return GenericResponse(
                items = this.userService.findUser()
        )
    }

    @GetMapping("list")
    @ApiOperation(value = "测试获取分页数据")
    fun list(@RequestParam(defaultValue = "0") page: Int,
             @RequestParam(defaultValue = "10") pageSize: Int): GenericResponse<List<User>> {
        return GenericResponse(
                items = this.userService.getUser(page, pageSize)
        )
    }

    // 从redis获取某个用户
    @ApiOperation(value = "测试")
    @GetMapping("getuserfromredis")
    fun getRedis(@RequestParam key: String): GenericResponse<User> {
        return GenericResponse(
                items = this.userService.getUserForRedis(key = key)
        )
    }

}