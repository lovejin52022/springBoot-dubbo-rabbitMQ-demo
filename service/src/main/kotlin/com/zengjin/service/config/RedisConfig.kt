package com.tangshanwenlv.tangshanwenchuang.server.config

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer
import com.zengjin.common.payload.User
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.RedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer


/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */
@Configuration
class RedisConfig {
    @Bean
    fun fastJsonRedisSerializer() = FastJsonRedisSerializer(User::class.java)

    @Bean
    @Throws(Exception::class)
    fun redisTemplate(
            redisConnectionFactory: RedisConnectionFactory,
            fastJsonRedisSerializer: RedisSerializer<*>): RedisTemplate<*, *> {
        val redisTemplate: RedisTemplate<*, *> = RedisTemplate<Any?, Any?>()
        redisTemplate.setConnectionFactory(redisConnectionFactory)
        redisTemplate.valueSerializer = fastJsonRedisSerializer
        redisTemplate.keySerializer = StringRedisSerializer()
        redisTemplate.afterPropertiesSet()
        return redisTemplate
    }
}