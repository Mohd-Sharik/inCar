package com.mongo.inCar.cloudsearchdomain;

import com.amazonaws.services.sagemaker.model.SearchRequest;

public class CloudSearchRequestBuilder {
	
	
	
	
	 public static SearchRequest buildSearchRequest(String query) {
	        // Create a basic search request
	        SearchRequest searchRequest = new SearchRequest()
	                .withQuery(query)
	                .withReturn("title", "description"); // Fields you want to return

	        // You can add more request parameters as needed
	        // searchRequest.with...

	        return searchRequest;
	    }

}
