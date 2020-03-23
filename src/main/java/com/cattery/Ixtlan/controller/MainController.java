package com.cattery.Ixtlan.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/some")
  public String greeting(Map<String, Object> model) {
    return "Cool!!!";
  }

}
