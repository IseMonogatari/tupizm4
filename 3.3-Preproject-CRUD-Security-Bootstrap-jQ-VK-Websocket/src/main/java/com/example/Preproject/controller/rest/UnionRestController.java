package com.example.Preproject.controller.rest;


import com.example.Preproject.dto.UserDTO;
import com.example.Preproject.model.User;
import com.example.Preproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UnionRestController {

    @Autowired
    private UserService userService;

    // Получить список всех пользователей
    @GetMapping("/all_users")
    public List<User> getUserList(Model model) {
        return userService.allUsers();
    }

    // Получить авторизованного пользователя
    @GetMapping("/authorized_user")
    public User getAuthorizedUser(@AuthenticationPrincipal User user) {
        return user;
    }

    // Получить пользователя по id
    @GetMapping("/user_id")
    public ResponseEntity<User> getUserById(@RequestParam("id") Integer id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    // Сохраняем пользователя
    @PostMapping("/new_user")
    public ResponseEntity<String> addUser(@RequestBody UserDTO userRegistrationDTO) {
        if (userService.save(userRegistrationDTO) != null) {
            return new ResponseEntity<>("Пользователь добавлен", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Данный пользователь не может быть админом",
                    HttpStatus.BAD_REQUEST);
        }
    }

    // Обновляем пользователя
    @PostMapping("/renewal_user")
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userRegistrationDTO) {
        if (userService.update(userRegistrationDTO) != null) {
            return new ResponseEntity<>("Пользователь обновлён", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Данный пользователь не может быть админом",
                    HttpStatus.BAD_REQUEST);
        }
    }

    // Удалить пользователяпо id
    @DeleteMapping("/remove_user_id")
    public void deleteUser(@RequestParam("id") Integer id) {
        userService.deleteUser(id);
    }
}
