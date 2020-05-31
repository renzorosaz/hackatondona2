package pe.com.tintegro.sigs.mapper;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public interface DonacionEntregaMapper {

	public Confirmacion insertDonacionEntrega(@Param("jsonDonacionEntrega")String jsonDonacionEntrega)throws Exception;
}
