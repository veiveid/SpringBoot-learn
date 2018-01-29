package com.veiveid.SpringBootlearn.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RedisTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private JedisPool jedisPool;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("test", "100",60*10, TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间


        /*// 保存对象
        User user = new User("超人", 20);
        redisTemplate.opsForValue().set("123", user);

        user = new User("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getName(), user);

        user = new User("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getName(), user);

        User u = (User)redisTemplate.opsForValue().get("123");
        System.out.println("======>"+u);*/

        System.out.println("=======>"+stringRedisTemplate.opsForValue().get("test"));

    }
}