package com.cxy.spring.boot.module.base.interceptor;

import com.alibaba.fastjson.JSON;
import com.cxy.spring.boot.module.base.core.context.SpringContextCoreHolder;
import com.cxy.spring.boot.module.base.core.enums.CharsetCode;
import com.cxy.spring.boot.module.base.interceptor.auth.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 权限拦截器.
 *
 * @author xy.chen
 * @version 1.0.0
 * @date 2019-08-05
 */
@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final Boolean property = SpringContextCoreHolder.getProperty("coco.interceptor.auth", Boolean.class);
        if (property != null && property) {
            final AuthService authService = SpringContextCoreHolder.getBean(AuthService.class);
            if (authService != null) {
                if (authService.preHandle(request, response, handler)) {
                    return true;
                } else {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    final HashMap<Object, Object> unauthorized = new HashMap<>();
                    unauthorized.put("errorCode", HttpStatus.UNAUTHORIZED);
                    unauthorized.put("errorMsg", "没有访问权限");
                    response.setCharacterEncoding(CharsetCode.forUtf8().name());
                    response.getWriter().write(JSON.toJSONString(unauthorized));
                    return false;
                }
            }
            return super.preHandle(request, response, handler);
        } else {
            return super.preHandle(request, response, handler);
        }
    }
}
