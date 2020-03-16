package com.cattery.Ixtlan.controller;

import com.cattery.Ixtlan.domain.Adults;
import com.cattery.Ixtlan.repo.AdultsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cats")
public class CatsController {

  private final AdultsRepo adultsRepo;

  @Autowired
  public CatsController(AdultsRepo adultsRepo) {
    this.adultsRepo = adultsRepo;
  }

  @GetMapping
  public List<Adults> Cats() {
    return adultsRepo.findAll();
  }

  @PostMapping
  public Adults create(@RequestBody Adults adult) {
    return adultsRepo.save(adult);
  }

}
