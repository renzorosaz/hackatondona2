package pe.com.tintegro.sigs.entidad;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class CheckDonacion {

	private Integer idCheckDonacion;
	private String codigoUsuario;
	private String descripcion;
	private Date fecha;
	private Integer puntosVerificados;
	private String foto;
	private Integer idOrganizacion;
	
	public Integer getIdCheckDonacion() {
		return idCheckDonacion;
	}
	public void setIdCheckDonacion(Integer idCheckDonacion) {
		this.idCheckDonacion = idCheckDonacion;
	}
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getPuntosVerificados() {
		return puntosVerificados;
	}
	public void setPuntosVerificados(Integer puntosVerificados) {
		this.puntosVerificados = puntosVerificados;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Integer getIdOrganizacion() {
		return idOrganizacion;
	}
	public void setIdOrganizacion(Integer idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}
	
	
}
