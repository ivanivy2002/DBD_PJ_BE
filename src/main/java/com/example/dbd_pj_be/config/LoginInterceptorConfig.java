package com.example.dbd_pj_be.config;

//import com.example.dbd_pj_be.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/*注册拦截器*/
@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {

    // 配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 创建自定义的拦截器对象
//        LoginInterceptor loginInterceptor = new LoginInterceptor();

        // 配置白名单并存放在一个List集合
        List<String> patterns = new ArrayList<>();

        // 前端相对url
        patterns.add("/home");
        patterns.add("/home/admin/manage");
        patterns.add("/home/admin");
        patterns.add("/home/vendor");
        patterns.add("/home/orduser");
        patterns.add("/login");
        patterns.add("/src/assets/**");  // 合法吗？？？

        // 后端相对url
        patterns.add("/user/reg");
        patterns.add("user/login");
        patterns.add("/shop/reg");
        patterns.add("/admin/login");
        patterns.add("/admin/display");
        //System.out.println(patterns);

//        registry.addInterceptor(loginInterceptor)    // 完成拦截器注册
//                .addPathPatterns("/**")              // 拦截哪些url，此处/**表示所有请求
//                .excludePathPatterns(patterns);      // 拦截器白名单 （需要加上前端的静态资源）

    }


}
