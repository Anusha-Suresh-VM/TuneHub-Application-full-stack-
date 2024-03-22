package com.example.springboot.Services;

import com.example.springboot.entities.ForgotPassword;

public interface ForgotPasswordService {
	public ForgotPassword createToken(String email);

}
