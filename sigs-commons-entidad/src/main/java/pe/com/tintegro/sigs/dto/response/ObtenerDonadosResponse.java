package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.Donados;

public class ObtenerDonadosResponse extends ResponseBase{
	
	public List<Donados> donadosList;

	public List<Donados> getDonadosList() {
		return donadosList;
	}

	public void setDonadosList(List<Donados> donadosList) {
		this.donadosList = donadosList;
	}
	
	

}
