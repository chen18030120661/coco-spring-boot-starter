package com.cxy.spring.boot.module.base.interceptor;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
@ConfigurationProperties("coco.interceptor.ignore")
public class IgnoreHandle {
    private List<String> root;
    private List<String> authIgnore;
    private List<String> logIgnore;
}
