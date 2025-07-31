package com.junjie.tryredis.demo;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class LettuceDemo {

//    public static void main(String[] args) {
//        var uri = RedisURI.builder()
//                .withHost("localhost")
//                .withPort(6379).build();
//
//        var redisClient = RedisClient.create(uri);
//        var conn = redisClient.connect();
//        var command = conn.sync();
////        log.info(command.ping());
//        conn.close();
//        command.shutdown(Boolean.TRUE);
//    }

    // 保存字符串
    public void saveString(io.lettuce.core.api.sync.RedisCommands<String, String> command, String key, String value) {
        command.set(key, value);
    }

    // 保存列表
    public void saveList(io.lettuce.core.api.sync.RedisCommands<String, String> command, String key, List<String> values) {
        command.rpush(key, values.toArray(new String[0]));
    }

    // 保存集合
    public void saveSet(io.lettuce.core.api.sync.RedisCommands<String, String> command, String key, Set<String> values) {
        command.sadd(key, values.toArray(new String[0]));
    }

    // 保存有序集合
    public void saveZSet(io.lettuce.core.api.sync.RedisCommands<String, String> command, String key, Map<String, Double> values) {
        values.forEach((member, score) -> command.zadd(key, score, member));
    }

    // 保存哈希
    public void saveHash(io.lettuce.core.api.sync.RedisCommands<String, String> command, String key, Map<String, String> values) {
        command.hset(key, values);
    }

    // 保存位图
    public void saveBitmap(io.lettuce.core.api.sync.RedisCommands<String, String> command, String key, long offset, int value) {
        command.setbit(key, offset, value);
    }

    // 保存HyperLogLog
    public void saveHyperLogLog(io.lettuce.core.api.sync.RedisCommands<String, String> command, String key, String... elements) {
        command.pfadd(key, elements);
    }

    // 保存Stream
    public void saveStream(io.lettuce.core.api.sync.RedisCommands<String, String> command, String key, Map<String, String> fields) {
        command.xadd(key, fields);
    }

    // 保存地理空间（Geo）
    public void saveGeo(io.lettuce.core.api.sync.RedisCommands<String, String> command, String key, double longitude, double latitude, String member) {
        command.geoadd(key, longitude, latitude, member);
    }

    // 保存JSON（需安装RedisJSON模块）
    public void saveJson(io.lettuce.core.api.sync.RedisCommands<String, String> command, String key, String path, String json) {
        command.dispatch(io.lettuce.core.protocol.CommandType.valueOf("JSON.SET"),
                new io.lettuce.core.output.StatusOutput<>(io.lettuce.core.codec.StringCodec.UTF8),
                new io.lettuce.core.protocol.CommandArgs<>(io.lettuce.core.codec.StringCodec.UTF8)
                        .addKey(key).add(path).add(json));
    }
}
