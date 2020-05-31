package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.InicioSesionOrganizacionRequest;
import pe.com.tintegro.sigs.dto.response.InicioSesionOrganizacionResponse;

public interface OrganizacionDAO {

	public InicioSesionOrganizacionResponse inicioSesionOrganizacion(InicioSesionOrganizacionRequest request)throws Exception;
}
