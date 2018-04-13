package com.elane.configs;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "spring.redis")
public class CustomRedisConfig {

//    private static Logger logger = Logger.getLogger(CustomRedisConfig.class);

    private String hostName;

    private int port;

    private String password;

    private int timeout;

    @Bean
    @RefreshScope
    public JedisPoolConfig getRedisConfig(){
        System.out.println("getRedisConfig");
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    @RefreshScope
    public JedisPool getJedisPool(){
        JedisPoolConfig config = getRedisConfig();
        System.out.println(hostName+" "+port+" "+timeout+" "+password);
        JedisPool pool = new JedisPool(config,hostName,port,timeout,password);
//        logger.info("init JredisPool ...");
        return pool;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        System.out.println(hostName);
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("1111111111111111111111");
        System.out.println(password);
        this.password = password;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
