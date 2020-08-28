package com.fish.show.controller;

import com.fish.show.thread.MyThread;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
public class SendMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法
    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() {
//        String messageId = String.valueOf(UUID.randomUUID());
//        String messageData = "test message, hello!";
//        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        Map<String,Object> map=new HashMap<>();
//        map.put("messageId",messageId);
//        map.put("messageData",messageData);
//        map.put("createTime",createTime);
//        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
//        for(int i=0;i<1000;i++) {
//            rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
//        }
        for (int i=1;i<=100;i++) {
            System.out.println(Thread.currentThread().getName() + "..." + i);




        }
        MyThread myThread = new MyThread("线程");

        myThread.start();
        return "ok";
    }

}
