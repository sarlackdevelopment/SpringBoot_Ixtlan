package com.cattery.Ixtlan.repo;

import com.cattery.Ixtlan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
