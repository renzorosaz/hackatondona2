package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.InicioSesionRequest;
import pe.com.tintegro.sigs.dto.request.InsertarUsuarioRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerUsuarioInfoRequest;
import pe.com.tintegro.sigs.dto.response.InicioSesionResponse;
import pe.com.tintegro.sigs.dto.response.InsertarUsuarioResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerUsuarioInfoResponse;

public interface UsuarioService {

	public InsertarUsuarioResponse insertarUsuario(InsertarUsuarioRequest request)throws Exception;
	public InicioSesionResponse inicioSesion(InicioSesionRequest request)throws Exception;
	public ObtenerUsuarioInfoResponse obtenerUsuarioInfo(ObtenerUsuarioInfoRequest request)throws Exception;
}
