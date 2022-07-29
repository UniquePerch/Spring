package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.Student;
import com.example.entity.TestBean;
import com.example.entity.User;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
//http://localhost:8080/mvc/yyds/index
public class MainController {
//    @RequestMapping("/test")
//    public ModelAndView test(){
//        return new ModelAndView("index");
//    }
//    @RequestMapping("/test2")
//    public ModelAndView test2(){
//        return new ModelAndView("home");
//    }

//    @GetMapping(value = "/index") //可以使用通配符？（任意一个字符） ,*(0-n个字符),**(当前目录或者基于当前目录的多级目录)
//    public String index(User user){//可以直接只能生成一个对象
//        System.out.println("收到一个请求参数:"+user);
//        return "index";
//    }
//    @Resource
//    TestBean bean;
//
//    @RequestMapping("/index")
//    public String index(){
//        return "redirect:home";重定向
//        return "forward:home";转发
//    }
//
//    @RequestMapping("/home")
//    public String home(){
//        return "home";
//    }
//    @RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
//    public String get(@PathVariable("id") String text){
//        System.out.println("获取用户："+text);
//        return "index";
//    }
//
//    @RequestMapping(value = "/index", method = RequestMethod.POST)
//    public String post(String username){
//        System.out.println("添加用户："+username);
//        return "index";
//    }
//
//    @RequestMapping(value = "/index/{id}", method = RequestMethod.DELETE)
//    public String delete(@PathVariable("id") String text){
//        System.out.println("删除用户："+text);
//        return "index";
//    }
//
//    @RequestMapping(value = "/index", method = RequestMethod.PUT)
//    public String put(String username){
//        System.out.println("修改用户："+username);
//        return "index";
//    }
    @RequestMapping("/index")
    public String get(){
        return "index";
    }

    @RequestMapping(value = "/home",produces = "application/json")
    @ResponseBody
    public User home(){
        User user = new User();
        user.setUsername("用户名");
        user.setPassword("密码");
        return user;
    }

    @RequestMapping(value = "/data",produces = "application/json")
    @ResponseBody
    public User getage(){
        User user = new User();
        user.setUsername("用户名");
        user.setAge(12);
        user.setPassword("密码");
        return user;
    }

    @RequestMapping(value = "/submit",produces = "application/json")
    @ResponseBody
    public String submit(@RequestBody Student student){
        System.out.println("接收到前端数据："+student);
        return "{\"success\": true}";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String upload(@RequestParam CommonsMultipartFile file) throws IOException {//文件上传
        File fileObj = new File("test.html");
        file.transferTo(fileObj);
        System.out.println("用户上传的文件已保存到："+fileObj.getAbsolutePath());
        return "文件上传成功！";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ResponseBody
    public void download(HttpServletResponse response){//文件下载
        response.setContentType("multipart/form-data");
        try(OutputStream stream = response.getOutputStream();
            InputStream inputStream = new FileInputStream("test.html")){
            IOUtils.copy(inputStream, stream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}