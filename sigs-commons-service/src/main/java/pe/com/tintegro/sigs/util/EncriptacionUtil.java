/**
 * 
 */
package pe.com.tintegro.sigs.util;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * @author daniel - 14 set. 2017
 *
 */
public class EncriptacionUtil
{
	private static final String ENCRYPTATION_ALGORITHM = "MD5";
	private static final String FORMAT_ENCODE = "UTF-8";
	private static final String ALGORITHM = "DESede";
	private static final String SECRET_KEY = "SiGSKeyGenerat0r";

	public static String encriptar(String texto) throws Exception
	{
		String base64EncryptedString = "";

		MessageDigest md = MessageDigest.getInstance( ENCRYPTATION_ALGORITHM );
		byte[] digestOfPassword = md.digest( SECRET_KEY.getBytes( FORMAT_ENCODE ));
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

		SecretKey key = new SecretKeySpec(keyBytes, ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key);

		byte[] plainTextBytes = texto.getBytes( FORMAT_ENCODE );
		byte[] buf = cipher.doFinal(plainTextBytes);
		byte[] base64Bytes = Base64.encodeBase64(buf);
		base64EncryptedString = new String(base64Bytes);

		return base64EncryptedString;
	}

	public static String desencriptar( String textoEncriptado ) throws Exception
	{
		
		String base64EncryptedString = "";
		String textoLimpio="";
		System.out.println(textoEncriptado);
		textoLimpio=textoEncriptado.replaceAll("%2B", "+");
		textoLimpio=textoLimpio.replaceAll("%40", "@");
		textoLimpio=textoLimpio.replaceAll("%3A", ":");
		textoLimpio=textoLimpio.replaceAll("%24", "$");
		textoLimpio=textoLimpio.replaceAll("%2C", ",");
		textoLimpio=textoLimpio.replaceAll("%3B", ";");
		textoLimpio=textoLimpio.replaceAll("%3D", "=");
		textoLimpio=textoLimpio.replaceAll("%3F", "?");
		textoLimpio=textoLimpio.replaceAll("%2F", "/");
		System.out.println(textoLimpio);
		byte[] message = Base64.decodeBase64(textoLimpio.getBytes( FORMAT_ENCODE ));
		MessageDigest md = MessageDigest.getInstance( ENCRYPTATION_ALGORITHM );
		byte[] digestOfPassword = md.digest(SECRET_KEY.getBytes( FORMAT_ENCODE ));
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		SecretKey key = new SecretKeySpec(keyBytes, ALGORITHM);

		Cipher decipher = Cipher.getInstance(ALGORITHM);
		decipher.init(Cipher.DECRYPT_MODE, key);

		byte[] plainText = decipher.doFinal(message);

		base64EncryptedString = new String( plainText, FORMAT_ENCODE );

		return base64EncryptedString;
	}

}
