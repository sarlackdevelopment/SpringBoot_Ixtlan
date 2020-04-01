package com.cattery.Ixtlan.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/")
  public String startPage(Map<String, Object> model) {
    return "hello";
  }

  @GetMapping("/hello")
  public String helloPage(Map<String, Object> model) {
    return "hello";
  }

  @GetMapping("/home")
  public String homePage(Map<String, Object> model) {
    return "home";
  }

}
