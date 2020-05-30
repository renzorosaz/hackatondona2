package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.DonaAcopioDAO;
import pe.com.tintegro.sigs.dto.request.ObtenerPuntosAcopioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerPuntosAcopioResponse;
import pe.com.tintegro.sigs.service.DonaAcopioService;


@Service("donaAcopioService")
public class DonaAcopioServiceImpl implements DonaAcopioService{

	@Autowired
	private DonaAcopioDAO donaAcopioDAO;
	
	@Override
	public ObtenerPuntosAcopioResponse obtenerPuntosAcopio(ObtenerPuntosAcopioRequest request) throws Exception {
		ObtenerPuntosAcopioResponse response = new ObtenerPuntosAcopioResponse();
		response = donaAcopioDAO.obtenerPuntosAcopio(request);
		return response;
	}

}
