package com.spring.imdb.entity;

import com.spring.imdb.constants.DbConstants;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "content")
@Data
public class Content {
    @Id
    private Long id;
    private String titleName;
    private String description;
    private DbConstants.ContentType contentType;
    //private Title title;
    private Integer seasonNo;
    private Integer episodeNo;
}
