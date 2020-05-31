package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.CheckDonacionDAO;
import pe.com.tintegro.sigs.dto.request.InsertarCheckDonacionRequest;
import pe.com.tintegro.sigs.dto.response.InsertarCheckDonacionResponse;
import pe.com.tintegro.sigs.service.CheckDonacionService;

@Service("checkDonacionService")
public class CheckDonacionServiceImpl implements CheckDonacionService{

	@Autowired
	private CheckDonacionDAO checkDonacionDAO;
	
	@Override
	public InsertarCheckDonacionResponse insertarCheckDonacion(InsertarCheckDonacionRequest request) throws Exception {
		InsertarCheckDonacionResponse response = new InsertarCheckDonacionResponse();
		response = checkDonacionDAO.insertarCheckDonacion(request);
		
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
