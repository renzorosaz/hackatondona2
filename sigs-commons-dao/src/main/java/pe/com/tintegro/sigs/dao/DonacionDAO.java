package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.InsertDonacionRequest;
import pe.com.tintegro.sigs.dto.response.InsertDonacionResponse;

public interface DonacionDAO {

	public InsertDonacionResponse insertDonacion(InsertDonacionRequest request)throws Exception;
}
