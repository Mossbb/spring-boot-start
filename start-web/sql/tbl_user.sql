-- auto-generated definition
create table tbl_user
(
    id          bigint unsigned auto_increment comment '主键' primary key,
    name        varchar(255)    not null comment '姓名',
    age         int(3) unsigned not null comment '年龄',
    create_time datetime        not null comment '创建时间',
    update_time datetime        not null on update CURRENT_TIMESTAMP comment '更新时间'
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;