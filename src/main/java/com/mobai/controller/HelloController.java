package com.mobai.controller;

import com.alibaba.fastjson2.JSONObject;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

//  @Resource
//  UserDetailsManager manager;
//
//  @Resource
//  BCryptPasswordEncoder encoder;

  @ResponseBody
  @PostMapping("/pay")
  public JSONObject pay(@RequestParam String account,
                        HttpSession session){
    JSONObject object = new JSONObject();
    object.put("status", true);
    System.out.println(object);
    return object;
  }
  // 这里不需要再鉴权，能够达到主页，那么一定是因为登陆成功了

//  //处理登录操作并跳转
//  @PostMapping("/login")
//  public String login(@RequestParam String username,
//                      @RequestParam String password,
//                      HttpSession session,
//                      Model model) {
//    if ("test".equals(username) && "123456".equals(password)) {
//      session.setAttribute("login", true);
//      return "redirect:/";
//    } else {
//      model.addAttribute("status", true);
//      return "login";
//    }
//  }
//  登陆有SpringSecurity控制，这里不再需要

  //处理首页或是登录界面跳转
  @GetMapping("/")
  public String index() {
    return "index";
  }

  //  @ResponseBody
  //  @PostMapping("/change-password")
  //  public JSONObject changePassword(@RequestParam String oldPassword,
  //                                   @RequestParam String newPassword) {
  //    manager.changePassword(oldPassword, encoder.encode(newPassword));
  //    JSONObject object = new JSONObject();
  //    object.put("success", true);
  //    return object;
  //  }
}