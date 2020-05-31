package pe.com.tintegro.sigs.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.sigs.dao.UsuarioDAO;
import pe.com.tintegro.sigs.dto.request.InicioSesionRequest;
import pe.com.tintegro.sigs.dto.request.InsertarUsuarioRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerUsuarioInfoRequest;
import pe.com.tintegro.sigs.dto.response.InicioSesionResponse;
import pe.com.tintegro.sigs.dto.response.InsertarUsuarioResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerUsuarioInfoResponse;
import pe.com.tintegro.sigs.entidad.Usuario;
import pe.com.tintegro.sigs.entidad.general.Confirmacion;
import pe.com.tintegro.sigs.mapper.UsuarioMapper;



@Repository("usuarioDAO")
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO{

	@Autowired
	private UsuarioMapper usuarioMapper;

	@Override
	public InsertarUsuarioResponse insertarUsuario(InsertarUsuarioRequest request) throws Exception {
		InsertarUsuarioResponse response = new InsertarUsuarioResponse();
		Confirmacion confirmacion = usuarioMapper.insertUsuario(request.getJsonUsuario());
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public InicioSesionResponse inicioSesion(InicioSesionRequest request) throws Exception {
	InicioSesionResponse response = new InicioSesionResponse();
		
		response = usuarioMapper.inicioSesion(request.getJsonUsuario());
		return response;
	}

	@Override
	public ObtenerUsuarioInfoResponse obtenerUsuarioInfo(ObtenerUsuarioInfoRequest request) throws Exception {
		ObtenerUsuarioInfoResponse response = new ObtenerUsuarioInfoResponse();
		Usuario usuario = usuarioMapper.obtenerUsuarioInfo(request.getIdUsuario());
		response.setUsuario(usuario);
		return response;
	}
	
}
