package com.xcl.xx.ssmdemo.controller;

import com.xcl.xx.ssmdemo.dao.pojo.User;
import com.xcl.xx.ssmdemo.entity.UserVO;
import com.xcl.xx.ssmdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    @ResponseBody// 结果返回json
    public List<UserVO> findAll(){
        List<UserVO> list = userService.findAll();
        return list;
    }

    @RequestMapping("/res/resultll")
    public String findAlOne(Model model, Integer id){
       User user = userService.findUserbyId(id);
       //ModelAndView mv = new ModelAndView();
        model.addAttribute("user", user);
       //mv.setViewName("/res/resultff");
       return  "/res/resultff";
    }

}

