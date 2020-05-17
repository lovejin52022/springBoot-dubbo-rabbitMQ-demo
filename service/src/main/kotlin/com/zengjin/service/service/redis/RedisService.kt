package com.zengjin.service.service.redis

import com.zengjin.common.exception.BadRequestException
import com.zengjin.common.payload.User
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import javax.annotation.Resource

/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */
@Service
class RedisService {
    @Resource
    private lateinit var redisTemplate: RedisTemplate<String, User>

    fun save(key: String, user: User) {
        this.redisTemplate.opsForValue().set(key, user)
    }

    fun get(key: String): User {
        return this.redisTemplate.opsForValue().get(key) ?: throw BadRequestException("未找到用户")
    }
}