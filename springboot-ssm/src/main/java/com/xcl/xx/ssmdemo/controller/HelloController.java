package com.xcl.xx.ssmdemo.controller;

import com.xcl.xx.ssmdemo.entity.DemoThymeLeaf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody // 返回json字符串的时候，采用这个注解
    public String hello(){
        return "JAVA1班,牛逼！！！";
    }

    @GetMapping("/home")
    public String index() {
        return "index";
    }

    @GetMapping("/home/dds")
    public String index2() {
        return "/dds/index2";
    }

    @GetMapping("/home/ddd")
    public String index(Model model) {
        DemoThymeLeaf user = new DemoThymeLeaf();
        user.setUsername("jack");
        user.setPassword("112233");
        user.setHobbies(Arrays.asList(new String[]{"singing", "dancing", "football"}));

        Map<String, String> maps = new HashMap<>();
        maps.put("1", "o");
        maps.put("2", "g");
        maps.put("3", "a");
        maps.put("4", "j");
        user.setSecrets(maps);
        model.addAttribute("user", user);

        return "/dds/indexDemo";
    }

}

