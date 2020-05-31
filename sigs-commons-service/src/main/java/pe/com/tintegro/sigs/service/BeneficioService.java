package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtenerBeneficioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerBeneficiosResponse;

public interface BeneficioService {

	public ObtenerBeneficiosResponse obtenerBeneficio(ObtenerBeneficioRequest request)throws Exception;
}
