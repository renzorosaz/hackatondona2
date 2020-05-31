package pe.com.tintegro.sigs.dto.request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.tintegro.sigs.entidad.CheckDonacion;

public class InsertarCheckDonacionRequest {

	private CheckDonacion checkDonacion;
	private String jsonCheckDonacion;
	
	public CheckDonacion getCheckDonacion() {
		return checkDonacion;
	}
	public void setCheckDonacion(CheckDonacion checkDonacion) {
		this.checkDonacion = checkDonacion;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(checkDonacion);
			String a = json.replaceAll(Pattern.quote("\\"), Matcher.quoteReplacement(""));
			String b = a.replaceAll(Pattern.quote("\"["), Matcher.quoteReplacement("["));
			String c = b.replaceAll(Pattern.quote("]\""), Matcher.quoteReplacement("]"));
			setJsonCheckDonacion(c);
			System.out.println("aea:->" + c);
		} catch (Exception e) {

		}
	}
	public String getJsonCheckDonacion() {
		return jsonCheckDonacion;
	}
	public void setJsonCheckDonacion(String jsonCheckDonacion) {
		this.jsonCheckDonacion = jsonCheckDonacion;
	}
	
	
}
