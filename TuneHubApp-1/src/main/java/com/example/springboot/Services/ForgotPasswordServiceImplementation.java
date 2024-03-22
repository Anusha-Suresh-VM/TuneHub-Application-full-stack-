package com.example.springboot.Services;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Repositories.ForgotPasswordRepository;
import com.example.springboot.entities.ForgotPassword;
@Service
public class ForgotPasswordServiceImplementation implements ForgotPasswordService  {
	@Autowired
	ForgotPasswordRepository fprepo;
	
	private static final int EXPIRATION_TIME_IN_MINUTES = 60;

	@Override
	public ForgotPassword createToken(String email) {
		String token=generateToken();
		Date expiryDate=calculateExpiryDate(EXPIRATION_TIME_IN_MINUTES);
		ForgotPassword fp=new ForgotPassword(email,token,expiryDate);
		return fprepo.save(fp);
		
		
		
	}
	private String generateToken() {
		SecureRandom secure=new SecureRandom();
		byte[]tokenBytes=new byte[32];
		secure.nextBytes(tokenBytes);
		return UUID.randomUUID().toString();
		
	}
	private Date calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return cal.getTime();
		
		
	}
	

}
