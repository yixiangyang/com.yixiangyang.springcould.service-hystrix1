package com.yixiangyang.springcould.hystrix.application;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class HystrixController {
	@Autowired
	private DiscoveryClient client;  
	/*@Autowired
	private Logger logger;*/
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	public String hello() throws Exception  {
		ServiceInstance instance = client.getLocalServiceInstance();
		int sleepTime = new Random().nextInt(3000);
		//logger.info("sleepTime:" + sleepTime);
		System.out.println("sleepTime:" + sleepTime);
		Thread.sleep(sleepTime);
		//logger.info("/hello,host:"+instance.getHost() +"service_id"+instance.getServiceId());
		System.out.println("/hello,host:"+instance.getHost() +"service_id"+instance.getServiceId());
		return "hello World";
	}
	
}
