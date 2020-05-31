package pe.com.tintegro.sigs.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.DonacionEntregaDAO;
import pe.com.tintegro.sigs.dto.request.InsertarDonacionEntregaRequest;
import pe.com.tintegro.sigs.dto.response.InsertarDonacionEntregaResponse;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.mapper.DonacionEntregaMapper;


@Repository("donacionEntregaDAO")
@Transactional
public class DonacionEntregaDAOImpl implements DonacionEntregaDAO{

	
	@Autowired
	private DonacionEntregaMapper donacionEntregaMapper;

	@Override
	public InsertarDonacionEntregaResponse insertarDonacionEntrega(InsertarDonacionEntregaRequest request)
			throws Exception {
		InsertarDonacionEntregaResponse response = new InsertarDonacionEntregaResponse();
		Confirmacion confirmacion = donacionEntregaMapper.insertDonacionEntrega(request.getJsonDonacionEntrega());
		response.setConfirmacion(confirmacion);
		return response;
	}


	
}
