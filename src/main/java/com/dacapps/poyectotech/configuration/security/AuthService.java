package com.dacapps.poyectotech.configuration.security;

import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dacapps.poyectotech.dto.LoginRequest;
import com.dacapps.poyectotech.dto.UserRequest;
import com.dacapps.poyectotech.dto.UsersDTO;
import com.dacapps.poyectotech.entities.Users;
import com.dacapps.poyectotech.repository.UsersRepository;
import com.dacapps.poyectotech.utils.exceptions.CredentialsException;
import com.dacapps.poyectotech.utils.exceptions.UserAlreadyExistsException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final JwtService jwtService;
	private final UsersRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;

	public AuthResponse login(LoginRequest request) {
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmailUser(), request.getClaveUser()));
		UserDetails user = userRepository.findByemailUser(request.getEmailUser()).orElseThrow();
		String token = jwtService.getToken(user);
		
		Optional<Users> optionalUser = userRepository.findByemailUser(user.getUsername());
		Users userInfo = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));
		UsersDTO userDto = new UsersDTO(userInfo.getIdUser(), userInfo.getNameUser(), userInfo.getEmailUser(), userInfo.getUserRol());
		
		return AuthResponse.builder()
				.token(token)
				.user(userDto)
				.build();
		}catch (BadCredentialsException e) {
			throw new CredentialsException("Usuario o clave incorrectos");
		}
	}

	public AuthResponse register(UserRequest request) {
	    try {
	        Users user = Users.builder()
	                .nameUser(request.getNameUser())
	                .emailUser(request.getEmailUser())
	                .passUser(passwordEncoder.encode(request.getPassUser()))
	                .userRol(request.getUserRol())
	                .build();

	        userRepository.save(user);

	        return AuthResponse.builder()
	                .token(jwtService.getToken(user))
	                .build();
	    } catch (DataIntegrityViolationException e) {
	        throw new UserAlreadyExistsException("El usuario con el correo " + request.getEmailUser() + " ya existe.");
	    }
	}

}
