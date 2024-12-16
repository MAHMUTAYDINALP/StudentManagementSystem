package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.model.User;
import com.example.StudentManagementSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

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
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
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
