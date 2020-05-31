package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.Usuario;

public class ObtenerUsuarioInfoResponse extends ResponseBase{
	
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
