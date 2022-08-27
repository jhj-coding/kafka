package com.jhj.kafka.controller;

import com.jhj.kafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
public class Product{
    private final static String TOPIC_NAME = "test"; //topic的名称

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @RequestMapping("/send")
    @Transactional
    public void send() throws ExecutionException, InterruptedException, TimeoutException {
        //发送消息（同步）~
        for (int i=0;i<1000;i++) {
            kafkaProducerService.sendMessageSync("test-batch", "key", "test message send~");
        }
        //发送消息并获取结果
//        kafkaProducerService.sendMessageGetResult("test","key","123");
        //发送消息异步
//        kafkaProducerService.sendMessageAsync("test","12");
        //组装消息
//        kafkaProducerService.testMessageBuilder("test","key","12");
        //事务消息
//        kafkaProducerService.sendMessageInTransaction("kafka-test-topic","key","12");
    }


}
