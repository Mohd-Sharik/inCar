package com.mongo.inCar.services;
import com.amazonaws.services.cloudsearchdomain.AmazonCloudSearchDomainClient;
import com.amazonaws.services.cloudsearchv2.AmazonCloudSearch;
import com.amazonaws.services.sagemaker.model.SearchRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloudSearchService {
	
	
//	
//    private final AmazonCloudSearch cloudSearchClient;
//
//    @Autowired
//    public CloudSearchService(AmazonCloudSearch cloudSearchClient) {
//        this.cloudSearchClient = cloudSearchClient;
//    }
//
//    public SearchRequest performSearch(String query) {
//        // Create and execute a search request
//        SearchRequest searchRequest = new SearchRequest()
//            .withQueryOptions("your_query_options")
//            .withQuery(query);
//        return cloudSearchClient.search(searchRequest);
//    }
//    
    
    
    
    private final AmazonCloudSearchDomainClient amazonCloudSearchDomain;
    
    public CloudSearchService(AmazonCloudSearchDomainClient amazonCloudSearchDomain) {
        this.amazonCloudSearchDomain = amazonCloudSearchDomain;
    }
    
    
    public Object search(String query) {
        SearchRequest searchRequest = new SearchRequest()
                .withQuery(query);

        return amazonCloudSearchDomain.search(searchRequest);
    }
    
    
    
}

