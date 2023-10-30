package com.mongo.inCar.config;

import java.time.Duration;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import com.amazonaws.services.cloudsearchdomain.AmazonCloudSearchDomainClient;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;



@Configuration
public class CacheConfig extends CachingConfigurerSupport {
	
	
	
	
	@Bean
    public AmazonCloudSearchDomainClient amazonCloudSearchDomain() {
        return new AmazonCloudSearchDomainClient()
                .withEndpoint("search-testdomain-1-sipjqjwzujhq3bk4jex4mzc62y.ap-southeast-2.cloudsearch.amazonaws.com");
    }
	
	
//	 @Bean
//	    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//	        return RedisCacheManager.builder(redisConnectionFactory)
//	            .cacheDefaults(defaultCacheConfig())
//	            .build();
//	 }
	
	
//	 @Bean
//	    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//	        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//	                // You can further customize cache configuration here, e.g., set expiration, serializer, etc.
//	                .entryTtl(Duration.ofMinutes(10));
//
//	        return RedisCacheManager.builder(redisConnectionFactory)
//	            .cacheDefaults(cacheConfiguration)
//	            .build();
//	    }
//
//	    @Bean
//	    @Override
//	    public KeyGenerator keyGenerator() {
//	        // Customize the key generation strategy if needed.
//	        // You can use the default SimpleKeyGenerator or implement a custom one.
//	        return new SimpleKeyGenerator();
//	    }

}
