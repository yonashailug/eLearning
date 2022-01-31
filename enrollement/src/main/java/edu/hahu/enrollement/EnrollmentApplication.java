package edu.hahu.enrollement;

import edu.hahu.enrollement.security.JwtConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
@EnableEurekaClient
public class EnrollmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnrollmentApplication.class, args);
    }
    @Bean
    public JwtConfig jwtConfig() {
        return new JwtConfig();
    }

}
