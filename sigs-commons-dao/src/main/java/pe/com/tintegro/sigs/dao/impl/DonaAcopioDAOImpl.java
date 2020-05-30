package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.DonaAcopioDAO;
import pe.com.tintegro.sigs.dto.request.ObtenerPuntosAcopioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerPuntosAcopioResponse;
import pe.com.tintegro.sigs.entidad.DonaAcopio;
import pe.com.tintegro.sigs.mapper.DonaAcopioMapper;

@Repository("donaAcopioDAO")
@Transactional
public class DonaAcopioDAOImpl implements DonaAcopioDAO{

	@Autowired
	private DonaAcopioMapper donaAcopioMapper;
	
	@Override
	public ObtenerPuntosAcopioResponse obtenerPuntosAcopio(ObtenerPuntosAcopioRequest request) throws Exception {
		ObtenerPuntosAcopioResponse response = new ObtenerPuntosAcopioResponse();
		List<DonaAcopio> donaAcopioList = donaAcopioMapper.obtenerPuntosAcopio();
		response.setDonaAcopioList(donaAcopioList);
		return response;
	}

}
