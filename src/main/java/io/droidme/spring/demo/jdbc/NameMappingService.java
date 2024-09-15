package io.droidme.spring.demo.jdbc;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class NameMappingService {

    private final JdbcTemplate jdbcTemplate;
    private final String sql = "select name from properties where id = ?";
    private final String NAME_ENDS_WITH = "motz";

    public NameMappingService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getProperty(String key) {
        try {
            return jdbcTemplate.queryForObject(sql, String.class, key);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public String getMappedName(String name) {
        String mappedName = name;
        if (name.endsWith(NAME_ENDS_WITH)) {
            String prefix = name.substring(0, name.length() - NAME_ENDS_WITH.length());
            String value = getProperty(prefix);
            if (value != null) {
                mappedName = value + NAME_ENDS_WITH;
            }
        }
        return mappedName;
    }
}
