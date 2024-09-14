package io.droidme.spring.demo.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoSpringJdbcApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoSpringJdbcApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoSpringJdbcApplication.class, args);
		Object jdbcTemplate = context.getBean("jdbcTemplate");
		log.info("jdbcTemplate: {}", jdbcTemplate);
	}

}
