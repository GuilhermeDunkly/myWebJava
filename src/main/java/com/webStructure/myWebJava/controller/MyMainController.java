package com.webStructure.myWebJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import com.webStructure.myWebJava.managerTable.tableMapping.User;

@Controller
public class MyMainController {
  @GetMapping("/")
  public String DefaultHome(Model model, HttpSession session) {
    User LoggedUser = (User) session.getAttribute("LoggedUser");
    if (LoggedUser != null) {
      model.addAttribute("username", LoggedUser.getUsername());
    } else {
      return "redirect:/Auth/login";
    }
    return "home";
  }

  @PostMapping("/Register")
  public String RegisterRedirect() {
    return "redirect:/register";
  }

  @PostMapping("/Logout")

  public String StopSession(HttpSession session) {
    session.invalidate();
    return "redirect:/Auth/login";
  }

}
