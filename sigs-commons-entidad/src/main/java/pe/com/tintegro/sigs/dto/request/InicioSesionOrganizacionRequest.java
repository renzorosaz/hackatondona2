package pe.com.tintegro.sigs.dto.request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.tintegro.sigs.entidad.Organizacion;

public class InicioSesionOrganizacionRequest {

	private Organizacion organizacion;
	private String jsonOrganizacion;
	
	public Organizacion getOrganizacion() {
		return organizacion;
	}
	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(organizacion);
			String a = json.replaceAll(Pattern.quote("\\"), Matcher.quoteReplacement(""));
			String b = a.replaceAll(Pattern.quote("\"["), Matcher.quoteReplacement("["));
			String c = b.replaceAll(Pattern.quote("]\""), Matcher.quoteReplacement("]"));
			setJsonOrganizacion(c);
			System.out.println("aea:->" + c);
		} catch (Exception e) {

		}
	}
	public String getJsonOrganizacion() {
		return jsonOrganizacion;
	}
	public void setJsonOrganizacion(String jsonOrganizacion) {
		this.jsonOrganizacion = jsonOrganizacion;
	}
	
	
}
