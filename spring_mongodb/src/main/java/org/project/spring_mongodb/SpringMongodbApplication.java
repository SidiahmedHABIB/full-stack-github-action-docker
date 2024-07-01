package org.project.spring_mongodb;

import org.project.spring_mongodb.category.Category;
import org.project.spring_mongodb.category.CategoryRepo;
import org.project.spring_mongodb.product.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongodbApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(List.of("http://localhost:4200", "http://localhost:8080"));
		config.setAllowedHeaders(Arrays.asList(
				HttpHeaders.ORIGIN,
				HttpHeaders.CONTENT_TYPE,
				HttpHeaders.ACCEPT,
				HttpHeaders.AUTHORIZATION
		));
		config.setAllowedMethods(Arrays.asList(
				"GET",
				"POST",
				"DELETE",
				"PUT",
				"PATCH"
		));
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);

	}
	//@Bean
	public  CommandLineRunner commandLineRunner(
			ProductRepo productRepo,
			CategoryRepo categoryRepo
	){
		return args -> {
			Category c1 = Category.builder().name("phones").description("smart phone").build();
			categoryRepo.insert(c1);
			Category c2 = Category.builder().name("pc").description("smart phone").build();
			categoryRepo.insert(c2);
		};
	}

}
