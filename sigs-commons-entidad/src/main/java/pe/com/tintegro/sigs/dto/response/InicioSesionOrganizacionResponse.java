package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public class InicioSesionOrganizacionResponse extends ResponseBase{
	
	private Confirmacion confirmacion;
	private Integer idOrganizacion;
	public Confirmacion getConfirmacion() {
		return confirmacion;
	}
	public void setConfirmacion(Confirmacion confirmacion) {
		this.confirmacion = confirmacion;
	}
	public Integer getIdOrganizacion() {
		return idOrganizacion;
	}
	public void setIdOrganizacion(Integer idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}
	
	
}
