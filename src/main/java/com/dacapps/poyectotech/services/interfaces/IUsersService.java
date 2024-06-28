package com.dacapps.poyectotech.services.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.dacapps.poyectotech.dto.UserRequest;
import com.dacapps.poyectotech.dto.UsersDTO;


@Service
public interface IUsersService {

	List<UsersDTO> findAll();
	
	UsersDTO findByIduser(int idUser);
	
	void save(UserRequest user);
	
	void update(UserRequest user, int iduser);
	
	void saveAll(List<UserRequest> users);
	
	void deleteById(int idUser);
}
