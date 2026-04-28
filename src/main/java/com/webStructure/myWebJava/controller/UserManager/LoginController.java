package com.webStructure.myWebJava.controller.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import com.webStructure.myWebJava.managerTable.managerInterface.userRepository;
import com.webStructure.myWebJava.managerTable.tableMapping.User;

@Controller
@RequestMapping("/Auth/login")

public class LoginController {
  @Autowired
  userRepository userRepository;

  @PostMapping("/submit")
  public String TryLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
    User Verifyuser = userRepository.findByUsername(username);

    if (Verifyuser != null && Verifyuser.getPassword().equals(password)) {
      session.setAttribute("LoggedUser", Verifyuser);
      return "redirect:/";
    } else {
      System.err.println("Erro ao verificar integridade das informações");
      return "redirect:/Auth/login";
    }
  }

  @PostMapping("/createAccount")
  public String RegisterRedirect() {
    return "redirect:/register";
  }

  @GetMapping
  public String formPage() {
    return "login";
  }

}
