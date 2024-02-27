package com.growhubsn.ghlink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;
// import org.springframework.context.annotation.Bean;//
//import org.springframework.web.client.RestTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
//@EnableEurekaClient
//@EnableFeignClients
public class GhlinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(GhlinkApplication.class, args);
	}

/* 
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	*/
	
}
