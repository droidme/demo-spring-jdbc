package io.droidme.spring.demo.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NameMappingServiceTest {

    @Autowired
    NameMappingService mappingService;

    @Test
    void testSomeMappings() {
        Map<String, String> testCases = Map.of(
                "Obermotz", "ChefChefChefmotz",
                "Mittelmotz", "ChefChefmotz",
                "Untermotz", "Chefmotz",
                "NixderGleichen", "NixderGleichen",
                "Testmotz", "Testmotz");

        testCases.forEach((name, expected) -> {
            assertThat(mappingService.getMappedName(name)).isEqualTo(expected);
        });
    }
}