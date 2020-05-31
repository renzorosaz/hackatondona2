package pe.com.tintegro.sigs.mapper;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.dto.response.InicioSesionOrganizacionResponse;

public interface OrganizacionMapper {

	public InicioSesionOrganizacionResponse inicioSesionOrganizacion(@Param("jsonOrganizacion")String jsonOrganizacion)throws Exception;
}
