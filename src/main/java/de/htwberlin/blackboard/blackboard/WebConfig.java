package de.htwberlin.blackboard.blackboard;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${cross.origin.url}")
    private String crossOriginUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(crossOriginUrl)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
