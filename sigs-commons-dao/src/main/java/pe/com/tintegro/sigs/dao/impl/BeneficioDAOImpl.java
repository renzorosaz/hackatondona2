package pe.com.tintegro.sigs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.BeneficioDAO;
import pe.com.tintegro.sigs.dto.request.ObtenerBeneficioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerBeneficiosResponse;
import pe.com.tintegro.sigs.entidad.Beneficio;
import pe.com.tintegro.sigs.mapper.BeneficioMapper;

@Repository("beneficioDAO")
@Transactional
public class BeneficioDAOImpl implements BeneficioDAO{

	@Autowired
	private BeneficioMapper beneficioMapper;
	
	@Override
	public ObtenerBeneficiosResponse obtenerBeneficio(ObtenerBeneficioRequest request) throws Exception {
		ObtenerBeneficiosResponse response = new ObtenerBeneficiosResponse();
		List<Beneficio> beneficioList = beneficioMapper.obtenerBeneficio();
		response.setBeneficioList(beneficioList);
		return response;
	}

}
