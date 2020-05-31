package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public class InicioSesionResponse extends ResponseBase{
	
	private Confirmacion confirmacion;
	private Integer idUsuario;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Confirmacion getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(Confirmacion confirmacion) {
		this.confirmacion = confirmacion;
	}
	
	

}