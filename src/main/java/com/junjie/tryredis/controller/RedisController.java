package com.junjie.tryredis.controller;

import com.junjie.tryredis.service.RedisTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import java.util.*;

@RestController
public class RedisController {
    private final RedisTemplateService redisTemplateService;

    public RedisController(RedisTemplateService redisTemplateService) {
        this.redisTemplateService = redisTemplateService;
    }

    @Operation(summary = "添加订单", description = "向 Redis 添加一个订单")
    @GetMapping("/order/add")
    public void add(){
        redisTemplateService.addOrder();
        var list = Arrays.asList(1,2,3,4,5);
        var map = Map.of("k1", null);
        var set = new HashSet<String>();
        set.add("1");
        var li = new ArrayList<String>();
        var hset = Set.of("1", "2", "3");

    }

    @Operation(summary = "获取订单", description = "根据 keyId 获取订单信息")
    @PostMapping("/order/{keyId}")
    public String get(@PathVariable Integer keyId) {
        return redisTemplateService.getOrder(keyId);
    }

    @Operation(summary = "获取UV", description = "获取IP UV")
    @GetMapping("/uv")
    public Long uv() {
        return redisTemplateService.uv();
    }
}
