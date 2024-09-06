package xyz.sadiulhakim.customer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Customer(
        @Id
        int id,
        String name
) {
}
