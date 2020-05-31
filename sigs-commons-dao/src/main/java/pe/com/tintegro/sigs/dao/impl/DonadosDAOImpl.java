package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.DonadosDAO;
import pe.com.tintegro.sigs.dto.request.ObtenerDonadosRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerDonadosResponse;
import pe.com.tintegro.sigs.entidad.Donados;
import pe.com.tintegro.sigs.mapper.DonadosMapper;

@Repository("donadosDAO")
@Transactional
public class DonadosDAOImpl  implements DonadosDAO{

	@Autowired
	private DonadosMapper donadosMapper;
	
	@Override
	public ObtenerDonadosResponse obtenerDonados(ObtenerDonadosRequest request) throws Exception {
		ObtenerDonadosResponse response = new ObtenerDonadosResponse();
		List<Donados> donadosList = donadosMapper.obtenerDonados();
		response.setDonadosList(donadosList);
		return response;
	}

}
