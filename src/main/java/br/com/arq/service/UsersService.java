package br.com.arq.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.arq.entity.Users;

@Service
public class UsersService {

	String secretWord = "profedsonbelem@gmail.comwww.arq.com.br=1=1+123;www.edsonbelemtreinamento.com.br";

	public String criptografia(String password) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		Users user = new Users();
		user.setPassword(password);
		md.update((user.getPassword() + secretWord).getBytes());
		BigInteger hash = new BigInteger(1, md.digest());
		String resposta1 = hash.toString(16);
		user.setPassword(resposta1);
		return user.getPassword();
	}

	public String tokenAcesso(String email) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		Users user = new Users();
		user.setEmail(email);
		md.update((user.getEmail() + secretWord).getBytes());
		BigInteger hash = new BigInteger(1, md.digest());
		String resposta1 = hash.toString(16);
		user.setToken(resposta1);
		return user.getToken();
	}

}
