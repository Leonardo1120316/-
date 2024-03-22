-- auto-generated definition
create table user
(
    id           bigint auto_increment
        primary key,
    username     varchar(256)                       null,
    userAccount  varchar(256)                       null,
    avartarUrl   varchar(1024)                      null,
    gender       tinyint                            null,
    userPassword varchar(512)                       not null,
    planetCode   varchar(52)                        null comment '星球编号',
    phone        varchar(128)                       null,
    email        varchar(512)                       null,
    userStatus   int      default 0                 null,
    createTime   datetime default CURRENT_TIMESTAMP null,
    updateTime   datetime default CURRENT_TIMESTAMP null,
    isDelete     tinyint  default 0                 not null,
    userRole     int      default 0                 not null
)
    comment '用户';

