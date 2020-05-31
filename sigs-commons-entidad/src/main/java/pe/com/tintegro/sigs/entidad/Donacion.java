package pe.com.tintegro.sigs.entidad;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Donacion {

	private Integer idDonacion;
	private String descripcionDonacion;
	private Date fecha;
	private Integer puntosGanados;
	private Integer idUsuario;
	
	public Integer getIdDonacion() {
		return idDonacion;
	}
	public void setIdDonacion(Integer idDonacion) {
		this.idDonacion = idDonacion;
	}
	public String getDescripcionDonacion() {
		return descripcionDonacion;
	}
	public void setDescripcionDonacion(String descripcionDonacion) {
		this.descripcionDonacion = descripcionDonacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getPuntosGanados() {
		return puntosGanados;
	}
	public void setPuntosGanados(Integer puntosGanados) {
		this.puntosGanados = puntosGanados;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
