package com.webStructure.myWebJava.controller.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.webStructure.myWebJava.managerTable.managerInterface.userRepository;
import com.webStructure.myWebJava.managerTable.tableMapping.User;

@RequestMapping("/register")
public class RegisterController {
  @Autowired
  private userRepository userRepository;

  @PostMapping("/signup")
  public String SaveUser(@RequestParam String username, @RequestParam String email) {
    User newUser = new User();
    newUser.setEmail(email);
    newUser.setUsername(username);
    userRepository.save(newUser);
    return "redirect:/register";
  };

  @GetMapping("/register")
  public String FormPage() {
    return "register";
  }
}
