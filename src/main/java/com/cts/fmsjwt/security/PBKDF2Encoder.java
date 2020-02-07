package com.cts.fmsjwt.security;

/**
 * @author 849289
 * */

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PBKDF2Encoder implements PasswordEncoder{
	
	@Value("${fms.password.encoder.secret}")
	private String secret;

	@Value("${fms.password.encoder.iteration}")
	private Integer iteration;

	@Value("${fms.password.encoder.keylength}")
	private Integer keylength;
	
	@Override
	public String encode(CharSequence cs) {
		/* Base64.Encoder encoder = Base64.getEncoder();  
		 String passwordencode=encoder.encodeToString(cs.toString().getBytes());*/
		try {
			byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
											.generateSecret(new PBEKeySpec(cs.toString().toCharArray(), secret.getBytes(), iteration, keylength))
											.getEncoded();
			return Base64.getEncoder().encodeToString(result);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
			throw new RuntimeException(ex);
		}
		/*return passwordencode;*/
	}

	@Override
	public boolean matches(CharSequence cs, String string) {
		return encode(cs).equals(string);
	}
	
}
