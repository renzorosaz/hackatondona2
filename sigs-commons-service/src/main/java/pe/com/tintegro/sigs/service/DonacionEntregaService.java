package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.InsertarDonacionEntregaRequest;
import pe.com.tintegro.sigs.dto.response.InsertarDonacionEntregaResponse;

public interface DonacionEntregaService {

	public InsertarDonacionEntregaResponse insertarDonacionEntrega(InsertarDonacionEntregaRequest request)throws Exception;
	
}
