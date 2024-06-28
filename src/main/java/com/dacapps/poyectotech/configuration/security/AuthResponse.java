package com.dacapps.poyectotech.configuration.security;

import com.dacapps.poyectotech.dto.UsersDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private UsersDTO user;
}
