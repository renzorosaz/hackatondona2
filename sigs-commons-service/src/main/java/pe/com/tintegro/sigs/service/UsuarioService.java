package pe.com.tintegro.sigs.service;

import pe.com.tintegro.sigs.dto.request.InsertarUsuarioRequest;
import pe.com.tintegro.sigs.dto.response.InsertarUsuarioResponse;

public interface UsuarioService {

	public InsertarUsuarioResponse insertarUsuario(InsertarUsuarioRequest request)throws Exception;
}
