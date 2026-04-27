package com.webStructure.myWebJava.controller.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.webStructure.myWebJava.managerTable.managerInterface.userRepository;
import com.webStructure.myWebJava.managerTable.tableMapping.User;

@Controller
@RequestMapping("/register")
public class RegisterController {
  @Autowired
  private userRepository userRepository;

  @PostMapping("/signup")
  public String SaveUser(@RequestParam String username, @RequestParam String email) {
    try {
      User newUser = new User();
      newUser.setEmail(email);
      newUser.setUsername(username);
      newUser.setName(username);
      userRepository.save(newUser);
      return "redirect:/";
    } catch (Exception e) {
      System.err.println("ERRO AO SALVAR O USUARIO");
      return "redirect:/register";
    }
  }

  @GetMapping
  public String FormPage() {
    return "register";
  }
}
