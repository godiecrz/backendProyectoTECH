package com.dacapps.poyectotech.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dacapps.poyectotech.dto.RolesDTO;
import com.dacapps.poyectotech.dto.RoleRequest;


@Service
public interface IRolesService {

	List<RolesDTO> findAll();
	
	RolesDTO findByIdrole(int idRole);
	
	void update(RoleRequest role, int idRole);
	
	void save(RoleRequest role);
	
	void deleteById(int idRole);
}
