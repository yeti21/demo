package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AController {

    @GetMapping({"/"})
    public String a(){
        return "index";
    }

    @GetMapping("/views/login")
    public String b(){
        return "/views/login";
    }

//    @PostMapping("/views/success")
//    public String bb(){
//        return "/views/success";
//    }

//    @PostMapping("/views/error")
//    public String bbb(){
//        return "/views/error";
//    }




    @GetMapping("/views/level1/1")
    public String c(){
        return "/views/level1/1";
    }

    @GetMapping("/views/level1/2")
    public String d(){
        return "/views/level1/2";
    }

    @GetMapping("/views/level1/3")
    public String e(){
        return "/views/level1/3";
    }

    @GetMapping("/views/level2/1")
    public String f(){
        return "/views/level2/1";
    }

    @GetMapping("/views/level2/2")
    public String g(){
        return "/views/level2/2";
    }

    @GetMapping("/views/level2/3")
    public String h(){
        return "/views/level2/3";
    }

    @GetMapping("/views/level3/1")
    public String i(){
        return "/views/level3/1";
    }

    @GetMapping("/views/level3/2")
    public String j(){
        return "/views/level3/2";
    }

    @GetMapping("/views/level3/3")
    public String k(){
        return "/views/level3/3";
    }



}
