package com.zengjin.service.config

import org.slf4j.LoggerFactory
import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.CorrelationData
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */

@Configuration
class RabbitConfiguration {
    private val logger = LoggerFactory.getLogger(RabbitConfiguration::class.java)

    @Bean
    fun rabbitTemplate(connectionFactory: CachingConnectionFactory): RabbitTemplate {
        connectionFactory.isPublisherConfirms = true
        connectionFactory.isPublisherReturns = true
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.setMandatory(true)
        rabbitTemplate.setConfirmCallback { correlationData: CorrelationData?, ack: Boolean, cause: String? -> this.logger.info("消息发送成功:correlationData({}),ack({}),cause({})".format(correlationData, ack, cause)) }
        rabbitTemplate.setReturnCallback { message: Message, replyCode: Int, replyText: String, exchange: String, routingKey: String -> this.logger.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}".format(exchange, routingKey, replyCode, replyText, message)) }
        return rabbitTemplate
    }

    // 声明队列
    @Bean
    fun queue1(): Queue = Queue("hello.queue1", true)

    @Bean
    fun queue2(): Queue {
        return Queue("hello.queue2", true)
    }

    // 声明交互器
    @Bean
    fun topicExchange(): TopicExchange {
        return TopicExchange("topicExchange")
    }

    // 绑定
    @Bean
    fun binding1(): Binding {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("key.1")
    }

    @Bean
    fun binding2(): Binding {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("key.#")
    }
}