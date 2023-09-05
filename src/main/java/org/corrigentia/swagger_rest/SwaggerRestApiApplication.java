package org.corrigentia.swagger_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties
public class SwaggerRestApiApplication {

	public static void main(final String[] args) {
		SpringApplication.run(SwaggerRestApiApplication.class, args);
	}

}
