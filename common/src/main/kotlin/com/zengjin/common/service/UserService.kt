package com.zengjin.common.service

import com.zengjin.common.payload.User

/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */
interface UserService {
    fun sayHello(str: String): String

    fun findUser(): User

    fun getUser(page: Int, pageSize: Int): List<User>

    fun getUserForRedis(key: String): User
}