package pe.com.tintegro.sigs.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.CheckDonacionDAO;
import pe.com.tintegro.sigs.dto.request.InsertarCheckDonacionRequest;
import pe.com.tintegro.sigs.dto.response.InsertarCheckDonacionResponse;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.mapper.CheckDonacionMapper;

@Repository("checkDonacionDAO")
@Transactional
public class CheckDonacionDAOImpl implements CheckDonacionDAO{

	@Autowired
	private CheckDonacionMapper checkDonacionMapper;

	@Override
	public InsertarCheckDonacionResponse insertarCheckDonacion(InsertarCheckDonacionRequest request) throws Exception {
		InsertarCheckDonacionResponse response = new InsertarCheckDonacionResponse();
		Confirmacion confirmacion = checkDonacionMapper.insertCheckDonacion(request.getJsonCheckDonacion());
		response.setConfirmacion(confirmacion);
		return response;
	}

}
