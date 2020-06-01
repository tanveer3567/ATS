package com.rsit.ats.service;

import static com.rsit.util.CommonUtils.ID;
import static com.rsit.util.CommonUtils.INTERNAL_SERVER_ERROR;

import java.io.IOException;
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
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsit.ats.client.ElasticHttpClient;
import com.rsit.ats.model.SystemMessage;
import com.rsit.ats.model.User;

@Service
public class UserService {

	@Autowired
	private ElasticHttpClient elasticHttp;

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation"})
	public SystemMessage addUser(User user) {

		SystemMessage message = null;
		try {
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
		} catch (IOException e) {
			message = new SystemMessage<String>();
			message.setStatus(500);
			message.setResult(INTERNAL_SERVER_ERROR);
		}
		return message;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SystemMessage validate(User user) {

		SystemMessage message = null;
		try {
			GetRequest request = new GetRequest("user", user.getUsername());
			GetResponse response = elasticHttp.getClient().get(request, RequestOptions.DEFAULT);
			String source = response.getSourceAsString();
			if (Objects.nonNull(source)) {
				message = new SystemMessage<Map<String, String>>();
				User dbUser = new ObjectMapper().readValue(source, User.class);
				Map<String, String> map = new HashMap<String, String>();
				map.put(ID, response.getId());
				if (dbUser.getPassword().equals(user.getPassword())) {
					map.put("message", "user validation successful");
					message.setStatus(200);
				} else {
					map.put("message", "user validation failed");
					message.setStatus(404);
				}
				message.setResult(map);
			} else {
				message = new SystemMessage<String>();
				message.setStatus(404);
				message.setResult("User not found");
			}
		} catch (UnsupportedOperationException | IOException e) {
			message = new SystemMessage<String>();
			message.setStatus(500);
			message.setResult(INTERNAL_SERVER_ERROR);
		}
		return message;
	}
}
