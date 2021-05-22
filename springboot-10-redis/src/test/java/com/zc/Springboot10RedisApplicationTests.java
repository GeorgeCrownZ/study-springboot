package com.zc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zc.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Springboot10RedisApplicationTests {

    @Autowired
    @Qualifier("MyRedisTemplate")
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

        //  redisTemplate   操作不同的数据类型，api和我们的指令是一样的

        //  opsForValue 操作字符串，类似String
        //  opsForList  操作List
        //  opsForSet
        //  opsForHash
        //  opsForZSet
        //  opsForGeo

        /*RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushDb();
        connection.flushAll();*/

        redisTemplate.opsForValue().set("mykey", "赵灿");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }

    @Test
    public void test1() throws JsonProcessingException {

        User user = new User("zc", 18);
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
