package com.cattery.Ixtlan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cats")
public class CatsController {
  @GetMapping
  public String Cats() {
    return "cats";
  }
}
