package com.example.demo;

import com.example.demo.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;

import java.io.File;

@SpringBootTest
class EmailApplicationTests {

    @Test
    void a(){

        File file1=new File(File.separator);
        System.out.println(file1);
        File file2=new File("D:\\Intellij IDEA Project\\demo\\email\\src\\main\\resources\\static\\demo.png");
        System.out.println(file2);

        String filepath="D:\\Intellij IDEA Project\\demo\\email\\src\\main\\resources\\static\\demo.png";
        System.out.println(filepath.lastIndexOf("\\"));

        String s=filepath.substring(filepath.lastIndexOf("\\")+1);
        System.out.println(s);

        FileSystemResource resource=new FileSystemResource(new File(filepath));
        System.out.println(resource);


    }



}
