package pe.com.tintegro.sigs.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class DonacionEntrega {

	private Integer idEntregaDonacion;
	private Integer idDonados;
	private Integer idOrganizacion;
	private String descripcion;
	private String foto;
	
	public Integer getIdEntregaDonacion() {
		return idEntregaDonacion;
	}
	public void setIdEntregaDonacion(Integer idEntregaDonacion) {
		this.idEntregaDonacion = idEntregaDonacion;
	}
	public Integer getIdDonados() {
		return idDonados;
	}
	public void setIdDonados(Integer idDonados) {
		this.idDonados = idDonados;
	}
	public Integer getIdOrganizacion() {
		return idOrganizacion;
	}
	public void setIdOrganizacion(Integer idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
}
