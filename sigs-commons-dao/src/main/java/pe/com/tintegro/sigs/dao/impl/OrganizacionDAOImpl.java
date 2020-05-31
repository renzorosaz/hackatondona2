package pe.com.tintegro.sigs.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.OrganizacionDAO;
import pe.com.tintegro.sigs.dto.request.InicioSesionOrganizacionRequest;
import pe.com.tintegro.sigs.dto.response.InicioSesionOrganizacionResponse;
import pe.com.tintegro.sigs.mapper.OrganizacionMapper;

@Repository("organizacionDAO")
@Transactional
public class OrganizacionDAOImpl implements OrganizacionDAO{

	@Autowired
	private OrganizacionMapper organizacionMapper;
	
	@Override
	public InicioSesionOrganizacionResponse inicioSesionOrganizacion(InicioSesionOrganizacionRequest request)
			throws Exception {
		InicioSesionOrganizacionResponse response = new InicioSesionOrganizacionResponse();
		response = organizacionMapper.inicioSesionOrganizacion(request.getJsonOrganizacion());
		return response;
	}

}
