DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` BIGINT(20) NOT NULL COMMENT '主键ID',
  `name` varchar(255) NOT NULL COMMENT '登录名称',
  PRIMARY KEY (id)
);