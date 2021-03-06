package com.cxy.spring.boot.module.base.core.enums;

import com.cxy.spring.boot.module.base.core.context.SpringContextCoreHolder;
import com.cxy.spring.boot.module.base.format.Result;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 格式化配置文件的枚举类.
 *
 * @author xy.chen
 * @version 1.0.0
 * @date 2019-08-05
 */
@Slf4j
@Getter
public enum FormatProperty {
    //数据格式化配置
    DATA("coco.format.response-data"),
    //数据格式化类配置
    CLASS_NAME("coco.format.class-name"),
    PROPERTY("coco.format.property"),
    //数据加密密钥配置
    DES_ROOT("coco.format.des3"),
    //数据加密参数密钥配置
    DES_PARAM("coco.format.des3.param"),
    //数据加密返回结果密钥配置
    DES_RESULT("coco.format.des3.result");

    private String key;
    private Object property;

    FormatProperty(String key) {
        this.key = key;
    }

    public static void init() {
        final FormatProperty[] values = FormatProperty.values();
        for (FormatProperty value : values) {
            value.property = SpringContextCoreHolder.getProperty(value.key);
        }
    }

    public String getString() {
        return property != null ? property.toString() : null;
    }

    public Boolean getBoolean() {
        return property != null ? Boolean.valueOf(property.toString()): null;
    }

    @SuppressWarnings("unchecked,unuse")
    public <T> T getProperty(Class<T> tClass) {
        return (T) this.property;
    }

    public static String des(FormatProperty format) {
        final Object property = format.getProperty();
        if (DES_ROOT.equals(format)) {
            return format.getString();
        }
        if (property == null) {
            return DES_ROOT.getString();
        }
        return null;
    }

    public static Class getFormatClass() {
        final String className = CLASS_NAME.getString();
        Class<?> formatClass = Result.class;
        try {
            if (StringUtils.isNotBlank(className)) {
                formatClass = Class.forName(className);
            }
        } catch (Exception e) {
            log.warn("[{}={}]配置错误", CLASS_NAME.getKey(), className);
        }
        return formatClass;
    }
}
