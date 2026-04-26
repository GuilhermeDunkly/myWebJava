package com.webStructure.myWebJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.webStructure.myWebJava.managerTable.managerInterface.userRepository;
import com.webStructure.myWebJava.managerTable.tableMapping.User;
import java.util.*;

@RestController
@RequestMapping("/users")

public class MyTableController {

  @Autowired
  private userRepository UserRepository;

  @GetMapping()
  public List<User> showAll() {
    return UserRepository.findAll();
  }
}
