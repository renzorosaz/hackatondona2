package pe.com.tintegro.sigs.mapper;

import java.util.List;

import pe.com.tintegro.sigs.entidad.Donados;

public interface DonadosMapper {
	
	public List<Donados> obtenerDonados()throws Exception;

}
