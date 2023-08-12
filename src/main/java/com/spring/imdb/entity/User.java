package com.spring.imdb.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_unique_id_generator")
    @TableGenerator(
            name = "user_unique_id_generator",
            table = "id_generator",
            pkColumnName = "object_name",
            valueColumnName = "last_id",
            pkColumnValue = "user",
            allocationSize = 5
    )
    private Long userId;
    @Column(name = "secure_user_id")
    private String secureUserId;
    private String name;
    private String password;
}
