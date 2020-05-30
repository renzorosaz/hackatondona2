package pe.com.tintegro.sigs.entidad.general;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Item implements Serializable
{
	
	@Override
	public String toString()
	{
		return "\nItem [ID=" + ID + ", valor=" + valor + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ID;
	private String valor;

	public int getID()
	{
		return ID;
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	public String getValor()
	{
		return valor;
	}

	public void setValor(String valor)
	{
		this.valor = valor;
	}

}
