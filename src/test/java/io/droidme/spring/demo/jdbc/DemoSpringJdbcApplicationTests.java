package io.droidme.spring.demo.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = {
		"/schema.sql"
})
class DemoSpringJdbcApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void TestSchema() {

		assertThat(jdbcTemplate)
				.isNotNull();

		Integer numTables = jdbcTemplate
				.queryForObject(
						"select count(*) from information_schema.tables"
						, Integer.class);

		assertThat(numTables)
				.isGreaterThan(0);

	}

}
