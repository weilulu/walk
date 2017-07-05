package com.walk.start.search.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@Configuration
//@EnableElasticsearchRepositories(basePackages = "org/aybx/wishes/user/elastic")
public class ElasticSearchConfig {

	@Value("${elasticsearch.host}")String host;
	@Value("${elasticsearch.port}")int port;
	
	@Bean
	public ElasticsearchTemplate elasticsearchTemplate(){
		return new ElasticsearchTemplate(client());
	}
	@Bean
	public Client client(){
		TransportClient client= new TransportClient();
        TransportAddress address = new InetSocketTransportAddress(host, port);
        client.addTransportAddress(address);
        return client;	
	}
}
