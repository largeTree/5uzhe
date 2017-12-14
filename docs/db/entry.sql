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

CREATE TABLE `movies` (
	`id` BIGINT(20) PRIMARY KEY,
	`name` VARCHAR(64) NOT NULL COMMENT'电影名',
	`class_id` BIGINT(20) NOT NULL COMMENT'电影类别',
	`market_date` DATE NULL COMMENT'上映时间',
	`desc` VARCHAR(512) DEFAULT '暂无' COMMENT'电影简介',
	`ed2k` TEXT NULL COMMENT'磁力链接',
	`torrent_path` VARCHAR(256) NULL COMMENT'种子地址',
	`thunder` TEXT NULL COMMENT'迅雷地址',
	`flag` TINYINT(4) NOT NULL DEFAULT 1 COMMENT'电影状态',
	`created_by` BIGINT(20) NOT NULL COMMENT'创建人',
	`created_date` DATETIME NOT NULL COMMENT'创建时间',
	`updated_by` BIGINT(20) NULL COMMENT'更新人',
	`updated_date` DATETIME NULL COMMENT'更新时间'
);