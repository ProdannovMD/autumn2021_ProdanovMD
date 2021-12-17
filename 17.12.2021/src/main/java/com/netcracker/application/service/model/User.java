package com.netcracker.application.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Integer id;
    private String name;
    private String email;
    private String password;

    @MappedCollection(keyColumn = "ID", idColumn = "USER_ID")
    private List<Product> products;
}
