package msoule.neotesting;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SomeDataRepository extends Neo4jRepository<SomeData, Long> {
}
