package com.example.demo.方式二;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class DeveloperPeoperty {
    @Value("${developer.name}")
    private String name;
    @Value("${developer.website}")
    private String website;
    @Value("${developer.phone-number}")
    private String phoneNumber;
    @Value("${developer.qq}")
    private String qq;

}
