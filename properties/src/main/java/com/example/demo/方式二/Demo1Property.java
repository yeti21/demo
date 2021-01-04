package com.example.demo.方式二;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Demo1Property {
    @Value("${server.servlet.context-path}")
    private String path;
}
