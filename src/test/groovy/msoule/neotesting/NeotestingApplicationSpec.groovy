package msoule.neotesting

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.transaction.annotation.Transactional
import org.testcontainers.containers.Neo4jContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Specification

@SpringBootTest
@Transactional
@Testcontainers
class NeotestingApplicationSpec extends Specification {

    static final Neo4jContainer<?> neo4j = new Neo4jContainer<>("neo4j:4.3.9")
        .withReuse(true)

    @DynamicPropertySource
    static void neo4jProperties(DynamicPropertyRegistry registry) {
        neo4j.start()
        registry.add("spring.neo4j.uri", neo4j::getBoltUrl)
        registry.add("spring.neo4j.authentication.username", () -> "neo4j")
        registry.add("spring.neo4j.authentication.password", neo4j::getAdminPassword)
    }

    @Autowired
    private SomeDataService service

    void "test"() {
        given:
        String s = ""

        when:
        s = "sdfasdf"
        service.save(SomeData.builder().name("sdfsdfsd").build())

        then:
        s
    }
}
