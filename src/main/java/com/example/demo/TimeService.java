package com.example.demo;

import java.util.Date;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    @Cacheable(cacheNames = "getTime")
    public Date getTime() {
        return new Date();
    }

    @Cacheable("currentTimeMillis")
    public Long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}