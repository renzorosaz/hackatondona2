package pe.com.tintegro.sigs.mapper;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public interface CheckDonacionMapper {

	public Confirmacion insertCheckDonacion(@Param("jsonCheckDonacion")String jsonCheckDonacion)throws Exception;
}
