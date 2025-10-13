package com.react.app.service.dto;

import lombok.Data;

@Data
public class UpdateUserPasswordDto {
    private int idUser;
    private String newPassword;
}
