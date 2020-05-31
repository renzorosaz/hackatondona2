package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.ObtenerDonadosRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerDonadosResponse;

public interface DonadosDAO {

	public ObtenerDonadosResponse obtenerDonados(ObtenerDonadosRequest request)throws Exception;
}
