package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtenerPuntosAcopioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerPuntosAcopioResponse;

public interface DonaAcopioService {

	public ObtenerPuntosAcopioResponse obtenerPuntosAcopio(ObtenerPuntosAcopioRequest request)throws Exception;
}
