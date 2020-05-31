package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.dao.BeneficioDAO;
import pe.com.tintegro.sigs.dto.request.ObtenerBeneficioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerBeneficiosResponse;
import pe.com.tintegro.sigs.service.BeneficioService;

@Service("beneficioService")
public class BeneficioServiceImpl implements BeneficioService{

	@Autowired
	private BeneficioDAO beneficioDAO;
	
	@Override
	public ObtenerBeneficiosResponse obtenerBeneficio(ObtenerBeneficioRequest request) throws Exception {
		ObtenerBeneficiosResponse response = new ObtenerBeneficiosResponse();
		response = beneficioDAO.obtenerBeneficio(request);
		return response;
	}

}
