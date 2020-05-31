package pe.com.tintegro.sigs.entidad;

import java.util.Date;

public class Beneficio {

	private Integer idBeneficio;
	private String nombre;
	private String oferta;
	private String descripcion;
	private String nota;
	private Date vencimiento;
	private String fotoCuadrado;
	private String fotoRectangular;
	private Integer puntos;
	private Boolean habilitado;
	
	public Integer getIdBeneficio() {
		return idBeneficio;
	}
	public void setIdBeneficio(Integer idBeneficio) {
		this.idBeneficio = idBeneficio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getOferta() {
		return oferta;
	}
	public void setOferta(String oferta) {
		this.oferta = oferta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public Date getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}
	public String getFotoCuadrado() {
		return fotoCuadrado;
	}
	public void setFotoCuadrado(String fotoCuadrado) {
		this.fotoCuadrado = fotoCuadrado;
	}
	public String getFotoRectangular() {
		return fotoRectangular;
	}
	public void setFotoRectangular(String fotoRectangular) {
		this.fotoRectangular = fotoRectangular;
	}
	public Integer getPuntos() {
		return puntos;
	}
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	public Boolean getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	
	
}
