package com.react.app.service;

import com.react.app.persistence.repository.UserRepository;
import com.react.app.service.dto.UpdateUserPasswordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /*
    @Transactional
    public void updatePassword(UpdateUserPasswordDto dto) {
        this.userRepository.updatePassword(dto);
    }

     */

    public boolean exists(String idUser) {
        return this.userRepository.existsById(idUser);
    }
}
