package com.webStructure.myWebJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class MyMainController {
  @GetMapping("/")
  public String DefaultHome() {
    return "home";
  }

  @PostMapping("/Register")
  public String RegisterRedirect() {
    return "redirect:register";
  }

  @GetMapping
  public String ShowRegister() {
    return "register";
  }
}
