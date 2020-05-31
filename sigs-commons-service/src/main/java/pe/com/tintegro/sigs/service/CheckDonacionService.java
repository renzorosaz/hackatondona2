package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.InsertarCheckDonacionRequest;
import pe.com.tintegro.sigs.dto.response.InsertarCheckDonacionResponse;

public interface CheckDonacionService {

	public InsertarCheckDonacionResponse insertarCheckDonacion(InsertarCheckDonacionRequest request)throws Exception;
}
