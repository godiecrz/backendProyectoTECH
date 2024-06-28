package com.dacapps.poyectotech.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dacapps.poyectotech.dto.RoleRequest;
import com.dacapps.poyectotech.dto.RolesDTO;
import com.dacapps.poyectotech.entities.Comments;
import com.dacapps.poyectotech.entities.Roles;
import com.dacapps.poyectotech.repository.RolesRepository;
import com.dacapps.poyectotech.services.interfaces.IRolesService;
import com.dacapps.poyectotech.utils.helpers.MHelpers;


@Component //permite crear injecciones de dependencias en otras partes del proyecto
public class RolesImpl implements IRolesService{

	//Injeccion de la dependencia del repositorio	
	@Autowired
	private RolesRepository rolesRepository;


	@Override
	public List<RolesDTO> findAll() {	
		List<RolesDTO> dto = new ArrayList<>();
		Iterable<Roles> roles = this.rolesRepository.findAll();
		
		for(Roles role : roles) {
			RolesDTO rolesDTO = MHelpers.modelMapper().map(role, RolesDTO.class);
			dto.add(rolesDTO);
		}
		return dto;
	}


	@Override
	public RolesDTO findByIdrole(int idRole) {
		Optional<Roles> roles = this.rolesRepository.findById(idRole);

		if(!roles.isPresent()) {
			return null;
		}

		return MHelpers.modelMapper().map(roles.get(), RolesDTO.class);
	}
	
	
	@Override
	public void update(RoleRequest request, int idRole) {
		Optional<Roles> role = this.rolesRepository.findById(idRole);
		Roles r = role.get();
		r.setDescriptionRole(request.getDescriptionRole());
		this.rolesRepository.save(r);
	}

	
	@Override
	public void save(RoleRequest role) {
		Roles roles = MHelpers.modelMapper().map(role, Roles.class);
		this.rolesRepository.save(roles);
	}
	

	@Override
	public void deleteById(int idRole) {
		this.rolesRepository.deleteById(idRole);
	}


}
