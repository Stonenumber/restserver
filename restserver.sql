CREATE DATABASE
IF
	NOT EXISTS `restserver`;
USE `restserver`;


CREATE TABLE
IF
	NOT EXISTS `t_integer` (
		`id` INT NOT NULL COMMENT 'id',
		`t_index` INT NOT NULL COMMENT '顺序',
		`sort` TINYINT NOT NULL COMMENT '是否排序',
		`t_value` INT NOT NULL COMMENT '输入值'
	) ENGINE = INNODB DEFAULT CHARSET = utf8;

CREATE TABLE
IF
	NOT EXISTS `t_string` (
		`id` INT NOT NULL COMMENT 'id',
		`t_index` INT NOT NULL COMMENT '顺序',
		`sort` TINYINT NOT NULL COMMENT '是否排序',
		`t_value` VARCHAR ( 255 ) NOT NULL COMMENT '输入值'

	) ENGINE = INNODB DEFAULT CHARSET = utf8;


CREATE TABLE
IF
	NOT EXISTS `t_big_decimal` (
		`id` INT NOT NULL COMMENT 'id',
		`t_index` INT NOT NULL COMMENT '顺序',
		`sort` TINYINT NOT NULL COMMENT '是否排序',
		`t_value` DECIMAL NOT NULL COMMENT '输入值'

	) ENGINE = INNODB DEFAULT CHARSET = utf8;

