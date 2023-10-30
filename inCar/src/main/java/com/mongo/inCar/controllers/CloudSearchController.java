package com.mongo.inCar.controllers;


import com.mongo.inCar.services.CloudSearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudSearchController {
    private final CloudSearchService cloudSearchService;

    @Autowired
    public CloudSearchController(CloudSearchService cloudSearchService) {
        this.cloudSearchService = cloudSearchService;
    }

    @GetMapping("/search")
    public SearchRequest search(@RequestParam String query) {
        return cloudSearchService.performSearch(query);
    }
}
