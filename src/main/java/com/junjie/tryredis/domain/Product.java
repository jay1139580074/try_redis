package com.junjie.tryredis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Builder
@Value
@AllArgsConstructor
public class Product {

    Long id;
    String name;
    Integer price;
    String detail;

}
