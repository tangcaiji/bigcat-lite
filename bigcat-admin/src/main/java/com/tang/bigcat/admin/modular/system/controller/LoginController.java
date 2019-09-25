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
 * 登录控制器eclipse1
 *
 * @author cjtang
 * @Date 2019-9-3
 */
@Controller
public class LoginController {

    @Autowired
    AppService appService;

    /**
     * 点击登录执行的动作1
     */
    @RequestMapping(value = "/login")
    public String loginVali(Model model) {
    	String app=appService.app();
    	model.addAttribute("app", app);
    	return "/login.jsp";
     
    }

}
