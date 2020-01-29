package com.assignment.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;

import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.assignment.wsdlfirst.CustomerOrdersWsImpl;

@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;

	@Bean
	public Endpoint endpoint() {
		Endpoint endPoint = new EndpointImpl(bus, new CustomerOrdersWsImpl());
		endPoint.publish("/customerordersservice");
		return endPoint;
	}

}
