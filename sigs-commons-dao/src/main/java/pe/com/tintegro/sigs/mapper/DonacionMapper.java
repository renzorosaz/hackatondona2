package pe.com.tintegro.sigs.mapper;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public interface DonacionMapper {

	public Confirmacion insertDonacion(@Param("jsonDonacion")String jsonDonacion)throws Exception;
}
