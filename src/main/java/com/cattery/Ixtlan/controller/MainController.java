package com.cattery.Ixtlan.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

  @GetMapping("/")
  //@RequestMapping(value = "/", method = RequestMethod.GET)
  public String greeting(Map<String, Object> model) {
    return "hello";
  }

  @GetMapping("/home")
  public String greeting1(Map<String, Object> model) {
    return "home";
  }

}
