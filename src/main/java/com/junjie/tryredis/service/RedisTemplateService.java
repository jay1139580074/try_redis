package com.junjie.tryredis.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
public class RedisTemplateService {
    private static final String KEY_PREFIX = "ord:";
    private final RedisTemplate redisTemplate;

    public RedisTemplateService(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void addOrder(){
        int keyId = ThreadLocalRandom.current().nextInt(1000+1);
        var valueNo = UUID.randomUUID().toString();

        var key = KEY_PREFIX + keyId;
        var value = "订单--"+valueNo;
        redisTemplate.opsForValue().set(key, value);

        log.info("添加订单: {} <<->> {}", key, value);
    }

    public String getOrder(Integer keyId) {
        return String.valueOf(redisTemplate.opsForValue().get(KEY_PREFIX + keyId));
    }

//    @PostConstruct
    private void initIp(){
        CompletableFuture.runAsync(() -> {
            String ip = null;
            for (int i = 0; i < 200; i++) {
                var random = new Random();
                ip = random.nextInt(256)+"." +
                        random.nextInt(256)+"." +
                        random.nextInt(256)+"." +
                        random.nextInt(256);
                var dd = redisTemplate.opsForHyperLogLog().add("hll", ip);
                log.info("添加IP: {} >> 次数：{}", ip, dd);
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.error("线程中断: {}", e.getMessage());
                }
            }

        });
    }

    public long uv(){
        return redisTemplate.opsForHyperLogLog().size("hll");
    }
}
