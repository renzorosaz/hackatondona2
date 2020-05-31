package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.DonacionDAO;
import pe.com.tintegro.sigs.dto.request.InsertDonacionRequest;
import pe.com.tintegro.sigs.dto.response.InsertDonacionResponse;
import pe.com.tintegro.sigs.service.DonacionService;

@Service("donacionService")
public class DonacionServiceImpl implements DonacionService {

	@Autowired
	private DonacionDAO donacionDAO;
	
	@Override
	public InsertDonacionResponse insertDonacion(InsertDonacionRequest request) throws Exception {
		InsertDonacionResponse response = new InsertDonacionResponse();
		response = donacionDAO.insertDonacion(request);
		
		if (response.getConfirmacion().getId() == 1)
		{
			response.setEstado(ResponseEstado.OK);
		
		} else if (response.getConfirmacion().getId() == 0)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
		}
		return response;
	}

}
