package com.example.Preproject.controller;

import com.example.Preproject.model.User;
import com.example.Preproject.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping("/post_I_WANT_TO_BE_A_ADMIN")
    public ResponseEntity<String> changeRequestToTrueAndPostCommentInVK(@RequestParam("user_id") Integer userId,
                                                                       @RequestParam("status") boolean status) {
        requestService.postCommentAdnChangeRequest(userId, status);
        return new ResponseEntity<>("Выполнили POST запрос.", HttpStatus.OK);
    }

    @GetMapping("/get_users_which_WANT_TO_BE_A_ADMIN")
    public List<User> getUserWhichWantToBeAAdmin() {
        return requestService.getUsersByRequest();
    }

    @PostMapping("/edit_user_status")
    public ResponseEntity<String> changeUserRequest(@RequestParam("user_id") Integer userId,
                                                   @RequestParam("status") boolean status) {
        requestService.editRequest(userId, status);
        return new ResponseEntity<>("Статус пользователя с ID = " +
                userId + " был успешно изменён на " +
                status + ".", HttpStatus.OK);
    }

    @GetMapping("/get_user_status")
    public boolean getUserResponse(@RequestParam("user_id") Integer userId) {
        return requestService.getUserRequest(userId);
    }

}
