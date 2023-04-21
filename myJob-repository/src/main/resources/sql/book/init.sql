CREATE TABLE `book`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `name`        varchar(32) NOT NULL COMMENT '名称',
    `library_id`  bigint(20) NOT NULL COMMENT '图书馆id',
    `author_id`   bigint(20) NOT NULL COMMENT '作者id',
    `enabled`     tinyint  DEFAULT 0 COMMENT '状态(0-下架，1-上架)',
    `stock`       bigint      NOT NULL COMMENT '库存（个）',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='图书表';