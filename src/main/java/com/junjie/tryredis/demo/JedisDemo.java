package com.junjie.tryredis.demo;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.StreamEntryID;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class JedisDemo {
//    public static void main(String[] args) {
//        Jedis jedis = new Jedis("localhost", 6379);
////        log.info(jedis.ping());
////
////        log.info(jedis.get("k1"));
//
//        jedis.aclCat();
//        jedis.close();
//
//    }

    // 保存字符串
    public void saveString(Jedis jedis, String key, String value) {
        jedis.set(key, value);
    }

    // 保存列表
    public void saveList(Jedis jedis, String key, List<String> values) {
        jedis.rpush(key, values.toArray(new String[0]));
    }

    // 保存集合
    public void saveSet(Jedis jedis, String key, Set<String> values) {
        jedis.sadd(key, values.toArray(new String[0]));
    }

    // 保存有序集合
    public void saveZSet(Jedis jedis, String key, Map<String, Double> values) {
        values.forEach((member, score) -> jedis.zadd(key, score, member));
    }

    // 保存哈希
    public void saveHash(Jedis jedis, String key, Map<String, String> values) {
        jedis.hset(key, values);
    }

    // 保存位图
    public void saveBitmap(Jedis jedis, String key, long offset, boolean value) {
        jedis.setbit(key, offset, value);
    }

    // 保存HyperLogLog
    public void saveHyperLogLog(Jedis jedis, String key, String... elements) {
        jedis.pfadd(key, elements);
    }

    // 保存Stream
    public void saveStream(Jedis jedis, String key, Map<String, String> fields) {
        jedis.xadd(key, (StreamEntryID) null, fields);
    }

    // 保存地理空间（Geo）
    public void saveGeo(Jedis jedis, String key, double longitude, double latitude, String member) {
        jedis.geoadd(key, longitude, latitude, member);
    }

    // 保存JSON（需安装RedisJSON模块）
    public void saveJson(Jedis jedis, String key, String path, String json) {
        jedis.sendCommand(redis.clients.jedis.Protocol.Command.valueOf("JSON.SET"), key, path, json);
    }
}


