package com.springboot.cxy.redis.test.redis;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {
    private String name;
    private int age;
}