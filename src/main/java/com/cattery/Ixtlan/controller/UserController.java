package com.cattery.Ixtlan.controller;

import com.cattery.Ixtlan.domain.Role;
import com.cattery.Ixtlan.domain.User;
import com.cattery.Ixtlan.repo.UserRepo;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

  private class CheckedRoles {

    private Role role;
    private String checked;

    public CheckedRoles(Role role, String checked) {
      this.role = role;
      this.checked = checked;
    }

  }

  @Autowired
  private UserRepo userRepo;

  @GetMapping
  public String userList(Model model) {
    model.addAttribute("users", userRepo.findAll());
    return "userList";
  }

  @GetMapping("{user}")
  public String userEditForm(@PathVariable User user, Model model) {

    List<CheckedRoles> roles = Arrays.asList(Role.values()).stream()
        .map(item -> {
          CheckedRoles some = new CheckedRoles(item, user.getRoles().contains(item) ? "checked": "");
          return some;
        })
        .collect(Collectors.toList());


    model.addAttribute("user", user);
    model.addAttribute("roles", roles);

    return "userEdit";
  }

  @PostMapping
  public String userSave(
      @RequestParam String username,
      @RequestParam Map<String, String> form,
      @RequestParam("userId") User user
  ) {
    user.setUsername(username);

    Set<String> roles = Arrays.stream(Role.values())
        .map(Role::name)
        .collect(Collectors.toSet());

      user.getRoles().clear();

    for (String key : form.keySet()) {
      if (roles.contains(key)) {
        user.getRoles().add(Role.valueOf(key));
      }
    }

    userRepo.save(user);

    return "redirect:/user";
  }

}
