package com.mongo.inCar.cloudsearchdomain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CloudSearchResponse {
	
	
	
	
	 private final SearchResponse searchResponse;

	    public CloudSearchResponse(SearchResponse searchResponse) {
	        this.searchResponse = searchResponse;
	    }

	    // You can define getters and methods to extract specific data from the response
	    public long getTotalHits() {
	        return searchResponse.getHits().getFound();
	    }

}
