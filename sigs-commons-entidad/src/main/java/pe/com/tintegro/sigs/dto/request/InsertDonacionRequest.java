package pe.com.tintegro.sigs.dto.request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.tintegro.sigs.entidad.Donacion;

public class InsertDonacionRequest {
	
	private Donacion donacion;
	private String jsonDonacion;
	
	public Donacion getDonacion() {
		return donacion;
	}
	public void setDonacion(Donacion donacion) {
		this.donacion = donacion;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(donacion);
			String a = json.replaceAll(Pattern.quote("\\"), Matcher.quoteReplacement(""));
			String b = a.replaceAll(Pattern.quote("\"["), Matcher.quoteReplacement("["));
			String c = b.replaceAll(Pattern.quote("]\""), Matcher.quoteReplacement("]"));
			setJsonDonacion(c);
			System.out.println("aea:->" + c);
		} catch (Exception e) {

		}
	}
	public String getJsonDonacion() {
		return jsonDonacion;
	}
	public void setJsonDonacion(String jsonDonacion) {
		this.jsonDonacion = jsonDonacion;
	}
	
	

}
