package com.elane.configs;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    //依据routingkey发送到exchange
    public void send(String exchange,String routingKey, Object message)  {

        amqpTemplate.convertAndSend(exchange,routingKey,message);
    }
}
