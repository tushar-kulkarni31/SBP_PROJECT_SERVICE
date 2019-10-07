package com.cognizant.fsd.sbaproject.mongodb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoApplicationConfig {


	static final String MONGURL_LOCAL = "mongodb://127.0.0.1:27017/?compressors=disabled&gssapiServiceName=mongodb";

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {

		//MongoClientURI uri  = new MongoClientURI(getMongoUrl()); 

		return new SimpleMongoDbFactory(new MongoClient(), "projectmanager");
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}

	/*
	 * private String getMongoUrl() { String mongoUrl = MONGURL_LOCAL;
	 * 
	 * return mongoUrl; }
	 */

}