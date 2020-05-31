package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.InsertarDonacionEntregaRequest;
import pe.com.tintegro.sigs.dto.response.InsertarDonacionEntregaResponse;

public interface DonacionEntregaDAO {

	public InsertarDonacionEntregaResponse insertarDonacionEntrega(InsertarDonacionEntregaRequest request)throws Exception;
}
