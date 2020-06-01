package com.rsit.ats.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsit.ats.client.ElasticHttpClient;
import com.rsit.ats.model.Applicant;
import com.rsit.ats.model.SystemMessage;

import static com.rsit.util.CommonUtils.*;

@Service
public class ApplicantService {
	
	@Autowired
	private ElasticHttpClient elasticHttp;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SystemMessage getApplicantById(String id) {

		SystemMessage message = null;
		try {
			GetRequest request = new GetRequest(APPLICANT, id);
			GetResponse response = elasticHttp.getClient().get(request, RequestOptions.DEFAULT);
			String source = response.getSourceAsString();
			if (Objects.nonNull(source)) {
				message = new SystemMessage<Applicant>();
				Applicant applicant = new ObjectMapper().readValue(source, Applicant.class);
				message.setStatus(200);
				message.setResult(applicant);
			} else {
				message = new SystemMessage<String>();
				message.setStatus(404);
				message.setResult(NOT_FOUND);
			}
		} catch (IOException e) {
			message = new SystemMessage<String>();
			message.setStatus(500);
			message.setResult(INTERNAL_SERVER_ERROR);
		}
		return message;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SystemMessage addApplicant(Applicant applicant) {

		SystemMessage message = null;
		try {
			IndexRequest request = new IndexRequest(APPLICANT)
					.source(new ObjectMapper().writeValueAsString(applicant), XContentType.JSON);
			IndexResponse response = elasticHttp.getClient().index(request, RequestOptions.DEFAULT);
			int status = response.status().getStatus();
			if (status == 201) {
				message = new SystemMessage<Map<String, String>>();
				Map<String, String> map = new HashMap<String, String>();
				map.put(ID, response.getId());
				map.put(MESSAGE2, PROFILE_SUCCESSFULLY_CREATED);
				message.setStatus(status);
				message.setResult(map);
			} else {
				message = new SystemMessage<String>();
				message.setStatus(status);
				message.setResult(NOT_FOUND);
			}
		} catch (IOException e) {
			message = new SystemMessage<String>();
			message.setStatus(500);
			message.setResult(INTERNAL_SERVER_ERROR);
		}
		return message;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SystemMessage updateApplicant(Applicant applicant, String id) {

		SystemMessage message = null;
		try {
			UpdateRequest request = new UpdateRequest(APPLICANT, id)
					.doc(new ObjectMapper().writeValueAsString(applicant), XContentType.JSON);
			UpdateResponse response = elasticHttp.getClient().update(request, RequestOptions.DEFAULT);
			int status = response.status().getStatus();
			if (status == 200) {
				message = new SystemMessage<Map<String, String>>();
				Map<String, String> map = new HashMap<String, String>();
				map.put(ID, response.getId());
				map.put(MESSAGE2, PROFILE_SUCCESSFULLY_UPDATED);
				message.setStatus(status);
				message.setResult(map);
			} else {
				message = new SystemMessage<String>();
				message.setStatus(status);
				message.setResult(NOT_FOUND);
			}
		} catch (IOException e) {
			message = new SystemMessage<String>();
			message.setStatus(500);
			message.setResult(INTERNAL_SERVER_ERROR);
		}
		return message;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SystemMessage deleteApplicant(String id) {

		SystemMessage message = null;
		try {
			DeleteRequest request = new DeleteRequest(APPLICANT, id);
			DeleteResponse response = elasticHttp.getClient().delete(request, RequestOptions.DEFAULT);
			int status = response.status().getStatus();
			if (status == 200) {
				message = new SystemMessage<Map<String, String>>();
				Map<String, String> map = new HashMap<String, String>();
				map.put(ID, response.getId());
				map.put(MESSAGE2, PROFILE_SUCCESSFULLY_DELETED);
				message.setStatus(status);
				message.setResult(map);
			} else {
				message = new SystemMessage<String>();
				message.setStatus(status);
				message.setResult(NOT_FOUND);
			}
		} catch (IOException e) {
			message = new SystemMessage<String>();
			message.setStatus(500);
			message.setResult(INTERNAL_SERVER_ERROR);
		}
		return message;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SystemMessage searchApplicant(Map<String, Object> searchMap) {

		SystemMessage message = null;
		try {
			SearchSourceBuilder sourceBuilder = new SearchSourceBuilder()
					.query(QueryBuilders.multiMatchQuery(searchMap.get(QUERY), "*"));
			SearchRequest request = new SearchRequest(APPLICANT).source(sourceBuilder);
			SearchResponse response = elasticHttp.getClient().search(request, RequestOptions.DEFAULT);
			int status = response.status().getStatus();
			if (status == 200) {
				message = new SystemMessage<Map<String, List<Map<String, Object>>>>();
				SearchHit[] hits = response.getHits().getHits();
				Map<String, List<Map<String, Object>>> map = new HashMap<String, List<Map<String, Object>>>();
				List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
				for (SearchHit hit : hits) {
					Map<String, Object> sourceMap = new LinkedHashMap<String, Object>();
					sourceMap.put(ID, hit.getId());
					sourceMap.put(APPLICANT, new ObjectMapper().readValue(hit.getSourceAsString(), Applicant.class));
					resultList.add(sourceMap);
				}
				map.put(RESULT, resultList);
				message.setStatus(status);
				message.setResult(map);
			} else {
				message = new SystemMessage<String>();
				message.setStatus(status);
				message.setResult(NOT_FOUND);
			}
		} catch (IOException e) {
			message = new SystemMessage<String>();
			message.setStatus(500);
			message.setResult(INTERNAL_SERVER_ERROR);
		}
		return message;
	}
}
