package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.DonadosDAO;
import pe.com.tintegro.sigs.dto.request.ObtenerDonadosRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerDonadosResponse;
import pe.com.tintegro.sigs.service.DonadosService;

@Service("donadosService")
public class DonadosServiceImpl implements DonadosService{

	@Autowired
	private DonadosDAO donadosDAO;
	
	@Override
	public ObtenerDonadosResponse obtenerDonados(ObtenerDonadosRequest request) throws Exception {
		ObtenerDonadosResponse response = new ObtenerDonadosResponse();
		response = donadosDAO.obtenerDonados(request);
		return response;
	}

}
