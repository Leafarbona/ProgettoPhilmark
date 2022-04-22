package it.philmark.docenza.controllers;

import it.philmark.docenza.models.User;
import it.philmark.docenza.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  UserRepository userRepository;

  @GetMapping("/getAllUsers")
  public List<User> getAllUsers() {
    return userRepository.getAllUsers();
  }

}
