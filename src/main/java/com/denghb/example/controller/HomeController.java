package com.denghb.example.controller;

import com.denghb.dbhelper.DbHelper;
import com.denghb.example.model.User;
import com.denghb.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ppd on 16/11/23.
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String index(Model model, HttpServletRequest request, @RequestParam(required = false,defaultValue = "张三")String name){
        User user = userService.queryByName(name);
        model.addAttribute("user",user);
        return "index";
    }

}
