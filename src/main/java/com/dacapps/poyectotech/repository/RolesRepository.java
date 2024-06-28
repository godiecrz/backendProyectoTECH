package com.dacapps.poyectotech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dacapps.poyectotech.entities.Roles;


@Repository
public interface RolesRepository extends CrudRepository<Roles, Integer>{
	
	
}
