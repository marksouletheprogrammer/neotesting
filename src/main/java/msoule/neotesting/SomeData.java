package msoule.neotesting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Mapping")
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class SomeData {

    @Id
    @GeneratedValue
    private long id;

    private String name;
}
