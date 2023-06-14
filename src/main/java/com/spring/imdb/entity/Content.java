package com.spring.imdb.entity;

import com.spring.imdb.constants.DbConstants;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "content")
@Data
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "title_name")
    private String titleName;

    private String description;

    @Enumerated
    @Column(name = "content_type")
    private DbConstants.ContentType contentType;

    @Column(name = "season_no")
    private Integer seasonNo;

    @Column(name = "episode_no")
    private Integer episodeNo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
}
