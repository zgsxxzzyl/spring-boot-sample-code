package com;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "springboot-es", type = "person")
public class Person {
    @Id
    private Long id;
    private String first_name;
    private String last_name;
    private int age;
    private int height;
    private int weight;
}
