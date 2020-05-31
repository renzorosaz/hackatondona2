package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.ObtenerDonadosRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerDonadosResponse;

public interface DonadosService {

	public ObtenerDonadosResponse obtenerDonados(ObtenerDonadosRequest request)throws Exception;
}
