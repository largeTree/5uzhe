CREATE TABLE `movie_class`(
	`id` BIGINT(20) PRIMARY KEY,
	`name` VARCHAR(6) NOT NULL COMMENT'类别名',
	`code` VARCHAR(32) NOT NULL COMMENT'类别编码',
	`flag` TINYINT(2) NOT NULL DEFAULT 1 COMMENT'类别状态',
	`created_by` BIGINT(20) NOT NULL COMMENT'创建人',
	`created_date` DATETIME NOT NULL COMMENT'创建时间',
	`updated_by` BIGINT(20) NOT NULL COMMENT'修改人',
	`updated_date` DATETIME NULL COMMENT'修改时间',
	UNIQUE KEY `UK_movie_class_code`(`code`)
);

CREATE TABLE `movie_tag`(
	`id` BIGINT(20) NOT NULL PRIMARY KEY,
	`name` VARCHAR(16) NOT NULL COMMENT'标签名',
	`code` VARCHAR(16) NOT NULL COMMENT'标签编码',
	`flag` TINYINT(2) NOT NULL DEFAULT 1 COMMENT'状态',
	`created_by` BIGINT(20) NOT NULL COMMENT'创建人',
	`created_date` DATETIME NOT NULL COMMENT'创建时间',
	`updated_by` BIGINT(20) NULL COMMENT'更新人',
	`updated_date` DATETIME NULL COMMENT'更新人',
	UNIQUE KEY `UK_movie_tag_name`(`name`),
	UNIQUE KEY `UK_mocie_tag_code`(`code`)
);

CREATE TABLE `movie` (
	`id` BIGINT(20) PRIMARY KEY,
	`name` VARCHAR(64) NOT NULL COMMENT'电影名',
	`cover` VARCHAR() NULL COMMENT'电影封面',
	`tag_ids` VARCHAR() NULL COMMENT'电影标签',
	`class_id` BIGINT(20) NOT NULL COMMENT'电影类别',
	`market_date` DATE NULL COMMENT'上映时间',
	`desc` VARCHAR(512) DEFAULT '暂无' COMMENT'电影简介',
	`flag` TINYINT(4) NOT NULL DEFAULT 1 COMMENT'电影状态',
	`created_by` BIGINT(20) NOT NULL COMMENT'创建人',
	`created_date` DATETIME NOT NULL COMMENT'创建时间',
	`updated_by` BIGINT(20) NULL COMMENT'更新人',
	`updated_date` DATETIME NULL COMMENT'更新时间'
);

CREATE TABLE `movie_get_way`(
	`id` BIGINT(20) PRIMARY KEY,
	`movie_id` BIGINT(20) NOT NULL COMMENT'对应电影',
	`type_id` TINYINT(4) NOT NULL COMMENT'类型',
	`target` VARCHAR(4096) NOT NULL COMMENT'目标，可能是种子路径，磁力链接，百度云链接，迅雷链接等',
	`flag` TINYINT(4) NOT NULL DEFAULT 1 COMMENT'状态',
	`created_date` DATETIME NOT NULL COMMENT'创建时间',
	`created_by` BIGINT(20) NOT NULL COMMENT'创建人',
	`updated_date` DATETIME NULL COMMENT'更新时间',
	`updated_by` BIGINT(20) NULL COMMENT'更新人'
);

