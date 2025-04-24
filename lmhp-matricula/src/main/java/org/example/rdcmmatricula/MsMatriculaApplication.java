package org.example.rdcmmatricula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "org.example.rdcmmatricula.feign")
@SpringBootApplication
public class MsMatriculaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsMatriculaApplication.class, args);
    }
}