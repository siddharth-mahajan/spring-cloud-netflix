//package com.sidmhjn.springcloudnetflix.configurationserver.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.netflix.discovery.EurekaClient;
//import com.netflix.discovery.shared.Application;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.stereotype.Component;
//
//@Component
//@RestController
//@RequestMapping("getData")
//public class ConfigurationEndpoints {
//	
//	@Autowired
//	private EurekaClient eurekaClient;
//
//	@GetMapping("/all")
//	public List<Application> serviceUrl() {
//	    List<Application> instance = eurekaClient.getApplications().getRegisteredApplications();
////		List<?> instance = eurekaClient.getInstancesById("DISCOVERY-DASHBOARD");
//		return instance;
//	}
//	
//	
//	@Autowired
//	private DiscoveryClient discoveryClient;
//	
//	@GetMapping("/svc")
//	public List<String> getApplications() {
//		List<String> instance = discoveryClient.getServices();
////		List<?> instance = discoveryClient.getInstancesById("DISCOVERY-DASHBOARD");
//		return instance;
//	}
//	
//	
//}
