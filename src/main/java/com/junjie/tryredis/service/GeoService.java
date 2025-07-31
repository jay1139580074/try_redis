package com.junjie.tryredis.service;

import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GeoService {

    private final static String KEY = "City";
    private final RedisTemplate redisTemplate;
    public GeoService(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean addCity() {
        var map = Map.of(
                "图书馆", new Point(31.192440241625846, 121.5416226400052)
        );
        return redisTemplate.opsForGeo().add(KEY, map) > 0;
    }

    public String getGeo(String cityName){
        var geo = redisTemplate.opsForGeo().position(KEY, cityName);
        return geo != null && !geo.isEmpty() ? geo.get(0).toString() : "City not found";
    }
}
