package com.accenture.lkm;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.client.RestClientException;

import com.accenture.lkm.util.CustomHystrixStateNotifier;
import com.netflix.hystrix.strategy.HystrixPlugins;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard //for dashboard display
public class Application {

    public static void main(String[] args) throws RestClientException, IOException {
    	HystrixPlugins.getInstance().registerEventNotifier(new CustomHystrixStateNotifier());
    	SpringApplication.run(Application.class, args);
      
    }
    
    
}