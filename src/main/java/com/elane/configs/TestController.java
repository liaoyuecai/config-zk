package com.elane.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
public class TestController {

    @Autowired
    JedisPool jedisPool;

    @Autowired
    RabbitSender sender;

    @RequestMapping("/redis")
    @ResponseBody
    public String testRedis(){
        System.out.println("controller");
        Jedis jedis = jedisPool.getResource();
        String url = jedis.hget("test","url");
        System.out.println("url:"+url);
        jedis.close();
        return "testRedis";
    }

    @RequestMapping("/rabbit")
    @ResponseBody
    public String testRabbit(){
        sender.send("ex.business","pmacp.business.msg","test1111");
        return "testRabbit";
    }
}
