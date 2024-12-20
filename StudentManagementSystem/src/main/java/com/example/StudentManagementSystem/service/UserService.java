package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.model.User;
import com.example.StudentManagementSystem.repository.UserRepository;

import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service // Servis katmanını belirten Spring anotasyonu
public class UserService {

    private final UserRepository userRepository;

    // Dependency injection (bağımlılık enjeksiyonu) ile repository sınıfını kullanıyoruz.
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Tüm kullanıcıları getiren fonksiyon
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //id ile kullanıcı getiren fonksiyon
    public User getUserById(Long id) {
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent()){

            return user.get();            
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found");
    }

    // Yeni  kullanıcı ekleyen fonksiyon
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Mevcut bir kullanıcıyı güncelleyen fonksiyon
    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(userDetails.getUsername()); // Kullanıcı adı güncelleniyor
                    user.setRole(userDetails.getRole()); // Rol bilgisi güncelleniyor
                    user.setEmail(userDetails.getEmail()); // E-posta güncelleniyor
                    user.setPasswordHash(userDetails.getPasswordHash()); // Şifre hash bilgisi güncelleniyor
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    //id ile  kullanıcı silen metot
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
