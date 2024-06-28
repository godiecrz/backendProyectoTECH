package com.dacapps.poyectotech.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dacapps.poyectotech.dto.UserRequest;
import com.dacapps.poyectotech.dto.UsersDTO;
import com.dacapps.poyectotech.entities.Users;
import com.dacapps.poyectotech.repository.UsersRepository;
import com.dacapps.poyectotech.services.interfaces.IUsersService;
import com.dacapps.poyectotech.utils.helpers.MHelpers;


@Component //permite crear injecciones de dependencias en otras partes del proyecto
public class UsersImpl implements IUsersService{

	//Injeccion de la dependencia del repositorio	
	@Autowired
	private UsersRepository usersRepository;


	@Override
	public List<UsersDTO> findAll() {	
		List<UsersDTO> dto = new ArrayList<>();
		Iterable<Users> users = this.usersRepository.findAll();
		
		for(Users user : users) {
			UsersDTO usersDTO = MHelpers.modelMapper().map(user, UsersDTO.class);
			dto.add(usersDTO);
		}
		return dto;
	}
	

	@Override
	public UsersDTO findByIduser(int idUser) {
		Optional<Users> users = this.usersRepository.findById(idUser);

		if(!users.isPresent()) {
			return null;
		}

		return MHelpers.modelMapper().map(users.get(), UsersDTO.class);
	}

	@Override
	public void save(UserRequest user) {
		Users users = MHelpers.modelMapper().map(user, Users.class);
		this.usersRepository.save(users);
	}

	
	@Override
	public void saveAll(List<UserRequest> users) {
		
		List<Users> u = new ArrayList<>();
		for(UserRequest user: users) {
			Users us = MHelpers.modelMapper().map(user, Users.class);
			u.add(us);
		}
		this.usersRepository.saveAll(u);

	}

	@Override
	public void deleteById(int idUser) {
		this.usersRepository.deleteById(idUser);
	}


	@Override
	public void update(UserRequest request, int iduser) {
		Optional<Users> user = this.usersRepository.findById(iduser);
		Users u = user.get();
		u.setNameUser(request.getNameUser());
		u.setEmailUser(request.getEmailUser());
		if(request.getUserRol() != null) {
			u.setUserRol(request.getUserRol());	
		}
		this.usersRepository.save(u);
	}

}
