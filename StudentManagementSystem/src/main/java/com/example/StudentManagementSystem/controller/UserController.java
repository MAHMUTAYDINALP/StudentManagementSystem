package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.helpers.UserHelper;
import com.example.StudentManagementSystem.model.User;
import com.example.StudentManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired 
    private final UserService userService;

   
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")                        //dogru olan bu
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

  /*   @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (!UserHelper.isValidUser(user)) {
            return ResponseEntity.badRequest().body("Geçersiz Kullanıcı Bilgisi!");
        }
        return ResponseEntity.ok(userService.createUser(user));
    }
*/
            @PostMapping("/users")
        public User createUser(@RequestBody User user) {
            return userService.addUser(user); // Doğru servis metodu çağrılıyor
        }
/* 
        @GetMapping("/users/{id}")
        public ResponseEntity<User> getUserById(@PathVariable Long id) {
            return userService.getUserById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }*/


    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        if (!UserHelper.isValidUser(user)) {
            return ResponseEntity.badRequest().body("Geçersiz Kullanıcı Bilgisi!");
        }
        return ResponseEntity.ok(userService.updateUser(id, user));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
