package com.rsit.ats.service;

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
import com.rsit.ats.model.Credentails;
import com.rsit.ats.model.SystemMessage;

import static com.rsit.util.CommonUtils.*;

@Service
public class CredentialsService {

	@Autowired
	private ElasticHttpClient elasticHttp;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SystemMessage addCredentials(Credentails credentials) {

		SystemMessage message = null;
		try {
			IndexRequest request = new IndexRequest(CREDENTIALS2)
					.source(new ObjectMapper().writeValueAsString(credentials), XContentType.JSON);
			IndexResponse response = elasticHttp.getClient().index(request, RequestOptions.DEFAULT);
			int status = response.status().getStatus();
			if (status == 201) {
				message = new SystemMessage<Map>();
				Map<String, String> map = new HashMap<String, String>();
				map.put(ID, response.getId());
				message.setStatus(status);
				message.setResult(map);
			} else {
				message = new SystemMessage<String>();
				message.setStatus(status);
				message.setResult(ERROR_OCCURED);
			}
		} catch (IOException e) {
			message = new SystemMessage<String>();
			message.setStatus(500);
			message.setResult(INTERNAL_SERVER_ERROR);
		}
		return message;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SystemMessage getCredentials(String id) {

		SystemMessage message = null;
		try {
			GetRequest request = new GetRequest(CREDENTIALS2, id);
			GetResponse response = elasticHttp.getClient().get(request, RequestOptions.DEFAULT);
			String source = response.getSourceAsString();
			if (Objects.nonNull(source)) {
				message = new SystemMessage<Credentails>();
				Credentails credentials = new ObjectMapper().readValue(source, Credentails.class);
				message.setStatus(200);
				message.setResult(credentials);
			} else {
				message = new SystemMessage<String>();
				message.setStatus(404);
				message.setResult(NOT_FOUND);
			}
		} catch (UnsupportedOperationException | IOException e) {
			message = new SystemMessage<String>();
			message.setStatus(500);
			message.setResult(INTERNAL_SERVER_ERROR);
		}
		return message;
	}
}
