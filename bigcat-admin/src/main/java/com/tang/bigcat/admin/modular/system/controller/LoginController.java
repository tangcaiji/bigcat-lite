package com.tang.bigcat.admin.modular.system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tang.bigcat.service.AppService;

import java.util.List;

/**
 * 登录控制器
 *
 * @author cjtang
 * @Date 2019-9-26
 */
@Controller
public class LoginController {

    //测试idea+git冲突处理
    private String name;

    @Autowired
    AppService appService;

    /**
     * 登录
     */
    @RequestMapping(value = "/login")
    public String loginVali(Model model) {
    	String app=appService.app();
    	model.addAttribute("app", app);
    	return "/login.jsp";
     
    }

}
