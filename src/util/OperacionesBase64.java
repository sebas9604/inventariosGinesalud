/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author tolis
 */
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;

public class OperacionesBase64 {
	
	public static String decodificar(String frase) {
		byte[] decoded = Base64.decodeBase64(frase);
		String fraseDecoded = new String(decoded);
		return fraseDecoded;
	}

	public static String codificar(String frase) {
		byte[] bytesEncoded = Base64.encodeBase64(frase.getBytes());
		frase = new String (bytesEncoded);
        return frase;
	}
}