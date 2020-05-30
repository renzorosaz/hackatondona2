package pe.com.tintegro.sigs.dao;

import pe.com.tintegro.sigs.dto.request.InsertarUsuarioRequest;
import pe.com.tintegro.sigs.dto.response.InsertarUsuarioResponse;

public interface UsuarioDAO {

	public InsertarUsuarioResponse insertarUsuario(InsertarUsuarioRequest request) throws Exception;
}
