package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.OrganizacionDAO;

import pe.com.tintegro.sigs.dto.request.InicioSesionOrganizacionRequest;
import pe.com.tintegro.sigs.dto.response.InicioSesionOrganizacionResponse;
import pe.com.tintegro.sigs.service.OrganizacionService;

@Service("organizacionService")
public class OrganizacionServiceImpl implements OrganizacionService{

	@Autowired
	private OrganizacionDAO organizacionDAO;
	
	@Override
	public InicioSesionOrganizacionResponse inicioSesionOrganizacion(InicioSesionOrganizacionRequest request)
			throws Exception {
		InicioSesionOrganizacionResponse response = new InicioSesionOrganizacionResponse();
		response = organizacionDAO.inicioSesionOrganizacion(request);
		System.out.println("service: "+response.getConfirmacion().getId());

		if (response.getConfirmacion().getId() == 1)
		{
			response.setEstado(ResponseEstado.OK);
		} else if (response.getConfirmacion().getId() == 0)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
		}
		return response;
	}

}
