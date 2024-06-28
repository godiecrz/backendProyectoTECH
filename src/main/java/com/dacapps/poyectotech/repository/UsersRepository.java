package com.dacapps.poyectotech.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dacapps.poyectotech.entities.Users;


@Repository
public interface UsersRepository extends CrudRepository<Users, Integer>{
	
	@Transactional(readOnly = true)  //se indica que este metodo es para solo consultar
	Optional<Users> findByidUser(int idUser); //el nombre del metodo debe contener campos existentes en la entidad 

	Optional<Users> findByemailUser(String emailuser);
	
}
