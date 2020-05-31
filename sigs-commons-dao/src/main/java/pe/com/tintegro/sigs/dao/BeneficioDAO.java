package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtenerBeneficioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerBeneficiosResponse;

public interface BeneficioDAO {

	public ObtenerBeneficiosResponse obtenerBeneficio(ObtenerBeneficioRequest request)throws Exception;
}
