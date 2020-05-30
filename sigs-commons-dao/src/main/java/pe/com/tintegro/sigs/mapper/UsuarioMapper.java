package pe.com.tintegro.sigs.mapper;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public interface UsuarioMapper {

	public Confirmacion insertUsuario(@Param("jsonUsuario")String jsonUsuario)throws Exception;
}
