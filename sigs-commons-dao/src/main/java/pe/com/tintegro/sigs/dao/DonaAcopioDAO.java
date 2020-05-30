package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtenerPuntosAcopioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerPuntosAcopioResponse;

public interface DonaAcopioDAO {
	
	public ObtenerPuntosAcopioResponse obtenerPuntosAcopio(ObtenerPuntosAcopioRequest request)throws Exception;

}
