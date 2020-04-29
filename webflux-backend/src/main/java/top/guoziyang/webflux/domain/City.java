package top.guoziyang.webflux.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "city")
public class City {

    @Id
    private String id;
    private Integer index;
    private String name;
    private String description;
    private String url;

}
