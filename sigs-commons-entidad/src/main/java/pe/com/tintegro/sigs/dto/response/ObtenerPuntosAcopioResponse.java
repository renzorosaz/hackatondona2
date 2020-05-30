package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.DonaAcopio;

public class ObtenerPuntosAcopioResponse  extends ResponseBase{

	private List<DonaAcopio> donaAcopioList;

	public List<DonaAcopio> getDonaAcopioList() {
		return donaAcopioList;
	}

	public void setDonaAcopioList(List<DonaAcopio> donaAcopioList) {
		this.donaAcopioList = donaAcopioList;
	}
	
	
}
