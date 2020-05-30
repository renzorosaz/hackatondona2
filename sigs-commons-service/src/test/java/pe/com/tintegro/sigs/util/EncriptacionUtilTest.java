/**
 * 
 */
package pe.com.tintegro.sigs.util;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author daniel - 15 set. 2017
 *
 */
public class EncriptacionUtilTest
{
	@Test
	@Ignore
	public void encriptarTest()
	{
		String texto = "1";

		try
		{
			System.out.println(EncriptacionUtil.encriptar(texto));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	//@Ignore
	public void desencriptarTest()
	{

		String texto = "95hwvFXv2Yk%3D";

		try
		{
			System.out.println(EncriptacionUtil.desencriptar(texto));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void encriptarCodUsuarioTest()
	{
		String texto = "1";
		try
		{
			System.out.println(EncriptacionUtil.encriptar(texto));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void desencriptarCodUsuarioTest()
	{
		String texto = "TX+IQfBMba4=";
		try
		{
			System.out.println(EncriptacionUtil.desencriptar(texto));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void encriptarEnteroTest()
	{
		Integer entero = 1;
		try
		{
			System.out.println(EncriptacionUtil.encriptar(entero.toString()));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void desencriptarEnteroTest()
	{
		String entero = "v2mrrYyTWiw=";
		try
		{
			System.out.println(EncriptacionUtil.desencriptar(entero));
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
