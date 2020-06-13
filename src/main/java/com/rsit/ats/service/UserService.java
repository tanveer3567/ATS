package com.rsit.ats.service;

import static com.rsit.util.CommonUtils.ID;
import static com.rsit.util.CommonUtils.INTERNAL_SERVER_ERROR;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsit.ats.client.ElasticHttpClient;
import com.rsit.ats.model.SystemMessage;
import com.rsit.ats.model.User;
import com.rsit.ats.model.UserRegister;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private ElasticHttpClient elasticHttp;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation"})
	public SystemMessage register(UserRegister  user) {

		SystemMessage message = null;
		try {
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			IndexRequest request = new IndexRequest("user", "_doc", user.getUsername())
					.source(new ObjectMapper().writeValueAsString(user), XContentType.JSON);
			IndexResponse response = elasticHttp.getClient().index(request, RequestOptions.DEFAULT);
			int status = response.status().getStatus();
			if (status == 201) {
				message = new SystemMessage<Map>();
				Map<String, String> map = new HashMap<String, String>();
				map.put(ID, response.getId());
				map.put("message", "profile successfully created");
				message.setStatus(status);
				message.setResult(map);
			} else {
				message = new SystemMessage<String>();
				message.setStatus(status);
				message.setResult("User already exists");
			}
		} catch (Exception e) {
			message = new SystemMessage<String>();
			message.setStatus(500);
			message.setResult(INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SystemMessage authenticate(User user) {
		
		SystemMessage message = null;
		try {
			message = new SystemMessage<SystemMessage>();
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			message.setResult(loadUserByUsername(user.getUsername()));
			message.setStatus(200);
		} catch (UsernameNotFoundException e) {
			message = new SystemMessage<String>();
			message.setStatus(404);
			message.setResult(e.getMessage());
		} catch (Exception e) {
			message = new SystemMessage<String>();
			message.setStatus(500);
			message.setResult(INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		org.springframework.security.core.userdetails.User user = null;
		try {
			GetRequest request = new GetRequest("user", username);
			GetResponse response = elasticHttp.getClient().get(request, RequestOptions.DEFAULT);
			String source = response.getSourceAsString();
			if (Objects.nonNull(source)) {
				User dbUser = new ObjectMapper().readValue(source, UserRegister.class);
				user = new org.springframework.security.core.userdetails.User(dbUser.getUsername(), dbUser.getPassword(),
						new ArrayList<>());
			} else {
				throw new UsernameNotFoundException("User not found with username: "+username);
			}
		} catch (UnsupportedOperationException | IOException e) {
			throw new UsernameNotFoundException("User not found with username: "+username);
		}
		return user;
	}
	
	public void authenticate(String username, String password) throws Exception {
		
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			System.out.println("ushcuishduiciulhsdilhhn");
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
