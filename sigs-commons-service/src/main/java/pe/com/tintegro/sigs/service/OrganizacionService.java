package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.InicioSesionOrganizacionRequest;
import pe.com.tintegro.sigs.dto.response.InicioSesionOrganizacionResponse;

public interface OrganizacionService {

	public InicioSesionOrganizacionResponse inicioSesionOrganizacion(InicioSesionOrganizacionRequest request)throws Exception;
}
