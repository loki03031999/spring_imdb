package com.spring.imdb.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "application")
public class Application {
    @Id
    @Column(name = "application_id")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "unique_application_id_generator")
    @TableGenerator(
            name = "unique_application_id_generator",
            table = "id_generator",
            pkColumnName = "object_name",
            valueColumnName = "last_id",
            pkColumnValue = "application",
            allocationSize = 5
    )
    private Long applicationId;
    @Column(name = "secure_application_id")
    private String secureApplicationId;
    private String name;
    private String secret;
}
