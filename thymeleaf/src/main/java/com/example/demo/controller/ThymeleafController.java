package com.example.demo.controller;


import com.example.demo.entity.Thymeleaf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
@RestController=@Controller+@ResponseBody
@RestController适合使用在不需要模板引擎处理,直接把数据响应给客户端的场景下
将返回的对象数据直接以JSON形式写入 HTTP Response中。。
 */
/*
@Controller需要视图模板引擎处理后才能将数据响应给客户端
 */
@Controller
public class ThymeleafController {

    /**
     * static文件夹
     * 静态页面
     * 1.直接访问 localhost:8080/demo/index/hello1.html
     */
    //重定向,地址栏会变
    @GetMapping("/s")
    public String s() {
        return "redirect:/index/hello1.html";
    }
    @GetMapping("/u")
    public void t(HttpServletResponse response) throws IOException {
        response.sendRedirect("/demo/index/hello1.html");
    }
    //转发
    @GetMapping("/w")
    public void w(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index/hello1.html").forward(request,response);
    }


    /**
     * templates文件夹
     * 动态页面
     * 只能通过controller跳转
     * 加不加后缀html都可以
     * 需要thymeleaf的包
     */
    @GetMapping("/a")
    public String a() {
        return "/thymeleaf/hello";
    }
    @GetMapping("/b")
    public String b() {
        return "/thymeleaf/hello.html";
    }
    @GetMapping("/r")
    public String r() {
        return "thymeleaf/hello";
    }
    /**
     * springboot无法重定向到templates目录下的问题
     *
     * redirect:和response.setRedirect("")的区别
     * 后者需要自己添加项目根目录
     */
    @GetMapping("/y")
    public String y(){return "redirect:/thymeleaf/hello.html ";}
    @GetMapping("/z")
    public void z(HttpServletResponse response) throws IOException {
        response.sendRedirect("/demo/thymeleaf/hello.html");
    }











    @GetMapping("/d")
    //Model 就是视图层渲染所需要的数据,return返回的是指定的页面路径
    public  String  d(@RequestParam(value = "name",required=false,defaultValue = "World")String name , Model model){
        model.addAttribute("name",name);
        return "thymeleaf/demo";
    }
    @GetMapping("/e")
     //ModelAndView 就是视图层渲染所需要的数据和要渲染的视图,return返回的是ModelAndView对象
    public ModelAndView e(@RequestParam(value = "name",required = false,defaultValue = "World")String name){
       //ModelAndView跳转地址方式一
      ModelAndView mv=new ModelAndView("thymeleaf/demo");
       mv.addObject("name",name);
        return mv;
    }
    @GetMapping("/f")
    public ModelAndView f(@RequestParam(value = "name",required = false,defaultValue = "World")String name, ModelAndView mv){
        //ModelAndView跳转地址方式二
        mv.setViewName("thymeleaf/demo");
        mv.addObject("name",name);
        return mv;
    }
    @GetMapping("/g")
    public String g(Model model){
       model.addAttribute("msg","老子是真的辛苦");
       model.addAttribute("name","陈亮");
      return "thymeleaf/demo";
    }






    @GetMapping("/h")
    public String h(Model model){
        Thymeleaf tu=new Thymeleaf();
        tu.setName("LiLi");
        tu.setAge(25);
        model.addAttribute("tu",tu);
       return "thymeleaf/thymeleaf1";
    }
    @GetMapping("/i")
    public String i(Model model){
        model.addAttribute("today",new Date());
        return "thymeleaf/thymeleaf2";
    }
    @GetMapping("/j")
    public String j(Model model){
        Thymeleaf tu=new Thymeleaf("陈诗诗",18);
        model.addAttribute("tu",tu);
        return "thymeleaf/thymeleaf2";
    }
    @GetMapping("/k")
    public String k(Model model){
        Thymeleaf tu=new Thymeleaf("高圆圆",20);
        model.addAttribute("tu",tu);
        return "thymeleaf/thymeleaf3";
    }
    @GetMapping("/l")
    public String l(Model model){
        List<Thymeleaf> userList=new ArrayList<>();
        Thymeleaf tu1=new Thymeleaf("高圆圆",20);
        Thymeleaf tu2=new Thymeleaf("陈诗诗",18);
        Thymeleaf tu3=new Thymeleaf("西施",19);
        Thymeleaf tu4=new Thymeleaf("貂蝉",28);
        Thymeleaf tu5=new Thymeleaf("杨玉环",25);
        userList.add(tu1);
        userList.add(tu2);
        userList.add(tu3);
        userList.add(tu4);
        userList.add(tu5);
        model.addAttribute("userList",userList);
        return "thymeleaf/thymeleaf4";
    }
     @GetMapping("/m")
      public  String m(Model model){
      Thymeleaf user=new Thymeleaf("王昭君",13);
      model.addAttribute("user",user);
      return "thymeleaf/thymeleaf5";
      }



      /*
      * Model
      * */
    @GetMapping("/n")
    public String  n(Model model){
        Thymeleaf tu=new Thymeleaf("陈亮",20);
        //封装查询信息，返回Java对象
        model.addAttribute("tu",tu);
        //返回视图名称
        return "model";
    }
     /*
     * ModelAndView
     * */
     @GetMapping("/o")
     public ModelAndView o(){
         Thymeleaf tu=new Thymeleaf("沈优",28);
         //需要创建ModelAndView对象
         ModelAndView mv=new ModelAndView();
         mv.setViewName("modelandview");
         //将数据放置到ModelAndView对象view中
         mv.addObject("tu",tu);
         return mv;
     }
    /*
  @ResponseBody的作用其实是将java对象转为json格式的数据。
  * @ResponseBody 注解是将返回的数据结构转换为 JSON 格式，写入到response对象的body区。
  * 在使用此注解之后不会再走视图处理器和模板引擎，而是直接将数据写入到输入流中，
  直接显示JSON格式数据。不加@ResponseBody报错。
   在 Spring Boot 中默认使用的 JSON 解析技术框架是 Jackson
  * */
    @GetMapping("/p")
    @ResponseBody
    public Thymeleaf p(){
        Thymeleaf tu=new Thymeleaf("仇丹淳",27);
        return  tu ;
    }
    @GetMapping("/q")
    @ResponseBody
    public  String q(){
        return "陈亮";
    }



}
