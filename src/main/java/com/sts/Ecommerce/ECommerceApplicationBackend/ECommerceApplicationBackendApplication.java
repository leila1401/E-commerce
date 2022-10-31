package com.sts.Ecommerce.ECommerceApplicationBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class ECommerceApplicationBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplicationBackendApplication.class, args);

	}


}
