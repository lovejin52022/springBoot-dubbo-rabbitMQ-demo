package com.zengjin.service.service.dubbo

import com.alibaba.dubbo.config.annotation.Service
import com.zengjin.common.payload.User
import com.zengjin.common.service.UserService
import com.zengjin.service.service.redis.RedisService
import com.zengjin.service.service.user.UserAdoService
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat
import java.util.*


/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */
@Service(version = "1.0.0")
@org.springframework.stereotype.Service
class UserServiceImpl(
        private val redisService: RedisService,
        private val userService: UserAdoService
): UserService {
    override fun sayHello(str: String): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        return dateFormat.format(Date()) + ": " + str
    }

    override fun findUser(): User {
        return  User(
                id = 1001,
                name = "啦啦",
                age = 10,
                address = "北京路"
        )
    }

    override fun getUser(page: Int, pageSize: Int): List<User> {
        val list = this.userService.search(page, pageSize)
        return list
    }

    override fun getUserForRedis(key: String): User {
        val user = User(
                id = 1008,
                name = "刘德华",
                age = 33,
                address = "中国香港"
        )
        this.redisService.save(user.id.toString(), user)
        return this.redisService.get(user.id.toString())
    }
}