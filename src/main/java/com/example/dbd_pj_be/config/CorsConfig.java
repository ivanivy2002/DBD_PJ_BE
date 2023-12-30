package com.example.dbd_pj_be.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@Configuration
@SpringBootConfiguration
public class CorsConfig implements WebMvcConfigurer {

    private String commodityAvatarDir = MyPath.getInstance().getCommodityAvatarPath() + "/";

    // 允许跨域资源共享（CORS）的请求映射，使得来自特定源的 HTTP请求可以访问该应用程序的资源
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /*
        TODO bug:   .allowedOrigins("*")改成 allowedOriginPatterns("*")
         */
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
//                .allowedOrigins("http://123.249.74.245") //设置允许跨域请求的域名
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

    // 配置资源处理器，将请求映射到本地文件系统的路径上
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 将该 URL 前缀的请求映射到 commodityAvatarDir 变量指定的本地磁盘文件夹上
        registry.addResourceHandler("/display/commodity/**").addResourceLocations("file:" + commodityAvatarDir);
    }

}
