package com.zengjin.service.service.queue

import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.connection.CorrelationData
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service
import java.util.*

/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */
@Service
class SenderService (
        private val rabbitTemplate: RabbitTemplate
) {

    private val logger = LoggerFactory.getLogger(SenderService::class.java)

    fun send(msg: String) {
        val correlationId = CorrelationData(UUID.randomUUID().toString())
        this.logger.info("开始发送消息 : " + msg.toLowerCase())
        val response = this.rabbitTemplate.convertSendAndReceive("topicExchange", "key.1", msg, correlationId).toString()
        this.logger.info("结束发送消息 : " + msg.toLowerCase())
        this.logger.info("消费者响应 : $response 消息处理完成")
    }
}

