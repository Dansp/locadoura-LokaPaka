package br.edu.fatec.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Cryptography {
 /*   public static String encripta (String senha) { 
        try { 
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); 
            digest.update(senha.getBytes()); 
            BASE64Encoder encoder = new BASE64Encoder(); 
            return encoder.encode (digest.digest()); 
        } catch (NoSuchAlgorithmException ns) { 
            ns.printStackTrace (); 
            return senha; 
        } 
    }*/
	
	public boolean verificaSenhaCad(String senha1, String senha2){
		if(senha1.equals(senha2)){
			return true;
		}
		return false;
	}
}
