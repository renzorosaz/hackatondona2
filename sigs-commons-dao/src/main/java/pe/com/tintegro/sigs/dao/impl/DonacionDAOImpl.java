package pe.com.tintegro.sigs.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.DonacionDAO;
import pe.com.tintegro.sigs.dto.request.InsertDonacionRequest;
import pe.com.tintegro.sigs.dto.response.InsertDonacionResponse;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.mapper.DonacionMapper;

@Repository("donacionDAO")
@Transactional
public class DonacionDAOImpl implements DonacionDAO{

	@Autowired
	private DonacionMapper donacionMapper;
	
	@Override
	public InsertDonacionResponse insertDonacion(InsertDonacionRequest request) throws Exception {
		InsertDonacionResponse response = new InsertDonacionResponse();
		Confirmacion confirmacion = donacionMapper.insertDonacion(request.getJsonDonacion());
		response.setConfirmacion(confirmacion);
		return response;
	}

}
