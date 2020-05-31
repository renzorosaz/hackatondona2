package pe.com.tintegro.sigs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dao.UsuarioDAO;
import pe.com.tintegro.sigs.dto.request.InicioSesionRequest;
import pe.com.tintegro.sigs.dto.request.InsertarUsuarioRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerUsuarioInfoRequest;
import pe.com.tintegro.sigs.dto.response.InicioSesionResponse;
import pe.com.tintegro.sigs.dto.response.InsertarUsuarioResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerUsuarioInfoResponse;
import pe.com.tintegro.sigs.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public InsertarUsuarioResponse insertarUsuario(InsertarUsuarioRequest request) throws Exception {
		InsertarUsuarioResponse response = new InsertarUsuarioResponse();
		response = usuarioDAO.insertarUsuario(request);
		
		if (response.getConfirmacion().getId() == 1)
		{
			response.setEstado(ResponseEstado.OK);
		
		} else if (response.getConfirmacion().getId() == 0)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
		}
		return response;
	}

	@Override
	public InicioSesionResponse inicioSesion(InicioSesionRequest request) throws Exception {
		InicioSesionResponse response = new InicioSesionResponse();
		response = usuarioDAO.inicioSesion(request);
		System.out.println("service: "+response.getConfirmacion().getId());

		if (response.getConfirmacion().getId() == 1)
		{
			response.setEstado(ResponseEstado.OK);
		} else if (response.getConfirmacion().getId() == 0)
		{
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
		}
		return response;
	}

	@Override
	public ObtenerUsuarioInfoResponse obtenerUsuarioInfo(ObtenerUsuarioInfoRequest request) throws Exception {
		ObtenerUsuarioInfoResponse response = new ObtenerUsuarioInfoResponse();
		response = usuarioDAO.obtenerUsuarioInfo(request);
		return response;
	}

}
