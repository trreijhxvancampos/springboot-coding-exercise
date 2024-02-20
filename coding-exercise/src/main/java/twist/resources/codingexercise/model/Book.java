package twist.resources.codingexercise.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private Integer id;
    private String name;
    private Author author;
}
