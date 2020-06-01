package com.rsit.ats.client;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticHttpClient {

	@Value("localhost")
	private String hostname;
	@Value("9200")
	private int port;

	@Bean(destroyMethod = "close")
	public RestHighLevelClient getClient() {

		return new RestHighLevelClient(RestClient.builder(new HttpHost(hostname, port)));
	}
}
