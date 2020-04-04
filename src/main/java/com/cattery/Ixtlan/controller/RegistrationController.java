package com.cattery.Ixtlan.controller;

import com.cattery.Ixtlan.domain.Role;
import com.cattery.Ixtlan.domain.User;
import com.cattery.Ixtlan.repos.UserRepo;
import java.util.Collections;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
  @Autowired
  private UserRepo userRepo;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping("/registration")
  public String registration() {
    return "registration";
  }

  @PostMapping("/registration")
  public String addUser(User user, Map<String, Object> model) {
    User userFromDb = userRepo.findByUsername(user.getUsername());

    if (userFromDb != null) {
      model.put("message", "User exists!");
      return "login";
    }

    user.setActive(true);
    user.setRoles(Collections.singleton(Role.USER));
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepo.save(user);

    return "redirect:/login";
  }
}
