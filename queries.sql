create database imdb_test;

use imdb_test;
--user entity creation
create table user(
    `id` bigint(20),
    `first_name` varchar(256) not null,
    `last_name` varchar(256),
    `secret` varchar(256),
    `status` enum('ACTIVE', 'INACTIVE'),
    `created` datetime DEFAULT CURRENT_TIMESTAMP,
    `last_modified` datetime,
    CONSTRAINT `pk_user` PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table content(
    `id` bigint(20),
    `title_name` varchar(256) not null,
    `description` varchar(1024),
    `status` enum('MOVIE', 'SERIES'),
    `season_no` int,
    `episode_no` int,
    `created` datetime DEFAULT CURRENT_TIMESTAMP,
    `last_modified` datetime,
    CONSTRAINT `pk_content` PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table title(
    `id` bigint(20),
    `title` varchar(256) not null,
    `genre` varchar(256),
    `language` varchar(256),
    `origin_country` varchar(256),
    `release_country` varchar(256),
    `created` datetime DEFAULT CURRENT_TIMESTAMP,
    `last_modified` datetime,
    CONSTRAINT `pk_title` PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table person(
    `id` bigint(20),
    `first_name` varchar(256) not null,
    `last_name` varchar(256),
    `date_of_birth` date,
    `date_of_death` date,
    `created` datetime DEFAULT CURRENT_TIMESTAMP,
    `last_modified` datetime,
    CONSTRAINT `pk_person` PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
