package pe.com.tintegro.sigs.dto.request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.tintegro.sigs.entidad.DonacionEntrega;

public class InsertarDonacionEntregaRequest {

	private DonacionEntrega donacionEntrega;
	private String jsonDonacionEntrega;
	
	public DonacionEntrega getDonacionEntrega() {
		return donacionEntrega;
	}
	
	public void setDonacionEntrega(DonacionEntrega donacionEntrega) {
		this.donacionEntrega = donacionEntrega;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(donacionEntrega);
			String a = json.replaceAll(Pattern.quote("\\"), Matcher.quoteReplacement(""));
			String b = a.replaceAll(Pattern.quote("\"["), Matcher.quoteReplacement("["));
			String c = b.replaceAll(Pattern.quote("]\""), Matcher.quoteReplacement("]"));
			setJsonDonacionEntrega(c);
			System.out.println("aea:->" + c);
		} catch (Exception e) {

		}
	}
	
	public String getJsonDonacionEntrega() {
		return jsonDonacionEntrega;
	}
	public void setJsonDonacionEntrega(String jsonDonacionEntrega) {
		this.jsonDonacionEntrega = jsonDonacionEntrega;
	}
	
	
}
