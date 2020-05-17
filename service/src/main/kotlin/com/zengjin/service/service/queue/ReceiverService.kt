package com.zengjin.service.service.queue

import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */
@Service
class ReceiverService {
    private val logger = LoggerFactory.getLogger(ReceiverService::class.java)

    @RabbitListener(queues = ["hello.queue1"])
    fun processMessage1(msg: String): String {
        this.logger.info(Thread.currentThread().name + " 接收到来自hello.queue1队列的消息：" + msg)
        return msg.toUpperCase()
    }

    @RabbitListener(queues = ["hello.queue2"])
    fun processMessage2(msg: String) {
        this.logger.info(Thread.currentThread().name + " 接收到来自hello.queue2队列的消息：" + msg)
    }
}