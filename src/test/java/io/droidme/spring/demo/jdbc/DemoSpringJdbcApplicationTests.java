package io.droidme.spring.demo.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Map;

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
    void schemaTableExists() {
        assertThat(jdbcTemplate)
                .isNotNull();
        Integer numTables = jdbcTemplate
                .queryForObject(
                        "select count(*) from information_schema.tables"
                        , Integer.class);
        assertThat(numTables)
                .isGreaterThan(0);
    }

    @Test
    void usersExist() {
        String sql = "select * from users";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        assertThat(mapList.size())
                .isEqualTo(2);
        assertThat(mapList.getFirst().get("id"))
                .isEqualTo("droidme");
    }
}
