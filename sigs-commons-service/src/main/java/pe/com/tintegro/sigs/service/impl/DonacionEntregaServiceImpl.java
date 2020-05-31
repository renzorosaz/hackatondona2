package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.DonacionEntregaDAO;
import pe.com.tintegro.sigs.dto.request.InsertarDonacionEntregaRequest;
import pe.com.tintegro.sigs.dto.response.InsertarDonacionEntregaResponse;
import pe.com.tintegro.sigs.service.DonacionEntregaService;

@Service("donacionEntregaService")
public class DonacionEntregaServiceImpl  implements DonacionEntregaService{

	@Autowired
	private DonacionEntregaDAO donacionEntregaDAO;
	
	@Override
	public InsertarDonacionEntregaResponse insertarDonacionEntrega(InsertarDonacionEntregaRequest request)
			throws Exception {
		InsertarDonacionEntregaResponse response = new InsertarDonacionEntregaResponse();
		response = donacionEntregaDAO.insertarDonacionEntrega(request);
		
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
