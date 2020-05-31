package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.InsertarCheckDonacionRequest;
import pe.com.tintegro.sigs.dto.response.InsertarCheckDonacionResponse;

public interface CheckDonacionDAO {

	public InsertarCheckDonacionResponse insertarCheckDonacion(InsertarCheckDonacionRequest request)throws Exception;
}
