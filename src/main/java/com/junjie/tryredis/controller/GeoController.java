package com.junjie.tryredis.controller;

import com.junjie.tryredis.service.GeoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoController {
    private final GeoService geoService;

    public GeoController(GeoService geoService) {
        this.geoService = geoService;
    }

    @Operation(summary = "add GEO", description = "add GEO")
    @GetMapping("/addGeo")
    public boolean addCity() {
        return geoService.addCity();
    }

    @Operation(summary = "get GEO", description = "get GEO")
    @GetMapping("/getGeo/{cityName}")
    public String getCity(@PathVariable String cityName) {
        return geoService.getGeo(cityName);
    }
}
