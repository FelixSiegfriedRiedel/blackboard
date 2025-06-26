package de.htwberlin.blackboard.blackboard;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000",
                                "https://blackboard-backend-hd9c.onrender.com",
                                "http://localhost:5173",
                        "https://blackboard-frontend-hd9c.onrender.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
