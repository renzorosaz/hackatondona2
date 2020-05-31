package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.InsertDonacionRequest;
import pe.com.tintegro.sigs.dto.response.InsertDonacionResponse;

public interface DonacionService {

	InsertDonacionResponse insertDonacion(InsertDonacionRequest request)throws Exception;
}
