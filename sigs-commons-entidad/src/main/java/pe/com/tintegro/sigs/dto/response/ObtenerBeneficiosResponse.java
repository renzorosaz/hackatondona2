package pe.com.tintegro.sigs.dto.response;

import java.util.List;

import pe.com.tintegro.sigs.entidad.Beneficio;

public class ObtenerBeneficiosResponse  extends ResponseBase{

	public List<Beneficio> beneficioList;

	public List<Beneficio> getBeneficioList() {
		return beneficioList;
	}

	public void setBeneficioList(List<Beneficio> beneficioList) {
		this.beneficioList = beneficioList;
	}
	
	
}
