package ch.flopes.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ch.flopes.spring.models.AccountRepository;

@Configuration
@ComponentScan(basePackageClasses={AccountRepository.class})
public class WebMvcConfig {
	
}
