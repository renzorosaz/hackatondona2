package pe.com.tintegro.sigs.dto.request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.tintegro.sigs.entidad.Usuario;

public class InicioSesionRequest {
	
	private Usuario usuario;
	private String jsonUsuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(usuario);
			String a = json.replaceAll(Pattern.quote("\\"), Matcher.quoteReplacement(""));
			String b = a.replaceAll(Pattern.quote("\"["), Matcher.quoteReplacement("["));
			String c = b.replaceAll(Pattern.quote("]\""), Matcher.quoteReplacement("]"));
			setJsonUsuario(c);
			System.out.println("Usuario:->" + c);
		} catch (Exception e) {

		}
	}
	public String getJsonUsuario() {
		return jsonUsuario;
	}
	public void setJsonUsuario(String jsonUsuario) {
		this.jsonUsuario = jsonUsuario;
	}
	


}
