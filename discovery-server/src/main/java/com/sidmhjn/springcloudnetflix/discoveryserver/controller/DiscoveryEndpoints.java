package com.sidmhjn.springcloudnetflix.discoveryserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
@RestController
@RequestMapping("getData")
public class DiscoveryEndpoints {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/svc")
	public List<String> getApplications() {
		List<String> instance = discoveryClient.getServices();
//		List<?> instance = discoveryClient.getInstancesById("DISCOVERY-DASHBOARD");
		return instance;
	}
		
	@GetMapping("/url/{serviceId}")
	public String serviceUrl2(@PathVariable String serviceId) {
//		String serviceId = "YOUR_SERVICE_ID"; // Replace with your service ID
        String eurekaUrl = "http://localhost:8761/eureka/apps/" + serviceId;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(eurekaUrl, String.class);

        String ipAddr = null;
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response);

            // Extracting instances array
            JsonNode instances = root.get("application").get("instance");

            // Iterate through instances
            for (JsonNode instance : instances) {
                ipAddr = instance.get("ipAddr").asText();
                System.out.println("IP Address: " + ipAddr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "Service ip for "+ serviceId +" application is "+ipAddr;
	}
	
	
}
