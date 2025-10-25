package com.react.app.web.controller;

import com.react.app.persistence.entity.UserEntity;
import com.react.app.service.UserService;
import com.react.app.service.dto.UpdateUserPasswordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
    @PutMapping("/password")
    public ResponseEntity<Void> updatePassword(@RequestBody UpdateUserPasswordDto dto) {
        if (this.userService.exists(dto.getIdUser())) {
            this.userService.updatePassword(dto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    */

}
