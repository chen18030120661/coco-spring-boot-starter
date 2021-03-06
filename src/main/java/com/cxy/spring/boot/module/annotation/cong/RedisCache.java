package com.cxy.spring.boot.module.annotation.cong;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCache {
    String cacheDir() default "";

    String cacheKey() default "";

    String expire() default "";

    TimeUnit timeUnit() default TimeUnit.SECONDS;
}
