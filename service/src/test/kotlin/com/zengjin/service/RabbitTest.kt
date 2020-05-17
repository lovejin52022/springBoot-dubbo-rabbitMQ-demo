package com.zengjin.service

import com.zengjin.service.service.queue.SenderService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */

@RunWith(value = SpringRunner::class)
@SpringBootTest
class RabbitTest {
    @Autowired
    private lateinit var senderService: SenderService

    @Test
    @Throws(Exception::class)
    fun sendTest() {
        for (i in 0..2) {
            val msg = Date().toString()
            this.senderService.send(msg)
            Thread.sleep(2000)
        }
    }
}