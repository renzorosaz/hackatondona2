package pe.com.tintegro.sigs.dto.response;

import pe.com.tintegro.sigs.entidad.general.Confirmacion;

public class ResponseBase
{
	private int estado;
	private String mensaje;
	private String codigoError;
	private String status;
	private Confirmacion confirmacion;


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEstado()
	{
		return estado;
	}

	public void setEstado(int estado)
	{
		this.estado = estado;
	}

	public String getMensaje()
	{
		return mensaje;
	}

	public void setMensaje(String mensaje)
	{
		this.mensaje = mensaje;
	}

	public String getCodigoError()
	{
		return codigoError;
	}

	public void setCodigoError(String codigoError)
	{
		this.codigoError = codigoError;
	}

	public Confirmacion getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(Confirmacion confirmacion) {
		this.confirmacion = confirmacion;
	}
}
