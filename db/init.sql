CREATE TABLE `wzy_tenant` (
                          `id` int NOT NULL AUTO_INCREMENT COMMENT '租户ID',
                          `name` varchar(255) DEFAULT NULL COMMENT '租户名称',
                          `domain` varchar(255) DEFAULT NULL COMMENT '租户的域名',
                          `status` tinyint DEFAULT NULL COMMENT '租户状态',
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `wzy_user` (
                        `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                        `account` varchar(50) DEFAULT NULL COMMENT '用户账号',
                        `name` varchar(50) DEFAULT NULL COMMENT '用户姓名',
                        `tenant_id` int DEFAULT NULL COMMENT '租户ID',
                        `group_id` int DEFAULT NULL COMMENT '群组ID',
                        `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `wzy_group` (
                         `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                         `name` varchar(50) DEFAULT NULL COMMENT '群组',
                         `tenant_id` int DEFAULT NULL COMMENT '租户ID',
                         `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB;
