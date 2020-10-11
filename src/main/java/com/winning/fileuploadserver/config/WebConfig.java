package com.winning.fileuploadserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ettingshausen
 * @date 2019/5/31 15:48
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // swagger-ui location has moved from http://host/context-path/swagger-ui.html to
        // http://host/context-path/swagger-ui/index.html OR http://host/context-path/swagger-ui/ for short.
        // This makes it work much better with pulling it as a web jar and turning it off using configuration properties if not needed.
        registry.addRedirectViewController("/", "/swagger-ui/");
    }
}
