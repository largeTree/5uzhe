
-- 商品详情表
CREATE TABLE `tbk_item_info`(
	`id` BIGINT(20) PRIMARY KEY,
	`num_iid` BIGINT(20) NOT NULL COMMENT'商品ID',
	`title` VARCHAR(256) NOT NULL COMMENT'商品标题',
	`pict_url` VARCHAR(512) NOT NULL COMMENT'商品主图',
	`small_images` JSON NOT NULL COMMENT'商品小图列表',
	`reserve_price` VARCHAR(16) NOT NULL COMMENT'商品一口价',
	`zk_final_price` VARCHAR(16) NOT NULL COMMENT'折后价',
	`user_type` TINYINT(2) NOT NULL COMMENT'卖家类型，0表示集市，1表示商城',
	`provcity` VARCHAR(8) NOT NULL COMMENT'宝贝所在地',
	`item_url` VARCHAR(512) NOT NULL COMMENT'商品地址',
	`nick` VARCHAR(32) NOT NULL COMMENT'卖家昵称',
	`seller_id` BIGINT(20) NOT NULL COMMENT'卖家昵称',
	`volume` INT(11) NOT NULL COMMENT'三十天销量',
	`cat_leaf_name` VARCHAR(16) NOT NULL COMMENT'叶子类目名称',
	`cat_name` VARCHAR(16) NOT NULL COMMENT'一级类目名称',
	`platform` TINYINT(2) NOT NULL COMMENT'平台类型，1代表PC端,2代表移动端',
);

-- 优惠券表
CREATE TABLE `tbk_coupon` (
	`id` BIGINT(20) PRIMARY KEY,
	`shop_title` VARCHAR(32) NOT NULL COMMENT'店铺名称',
	`user_type` TINYINT(2) NOT NULL COMMENT'卖家类型，0表示集市，1表示商城',
	`title` VARCHAR(256) NOT NULL COMMENT'商品标题',
	`nick` VARCHAR(32) NOT NULL COMMENT'卖家昵称',
	`seller_id` BIGINT(20) NOT NULL COMMENT'卖家ID',
	`volume` INT(11) NOT NULL COMMENT'30天销量',
	`zk_final_price` VARCHAR(16) NOT NULL COMMENT'折后价',
	`small_images` JSON NOT NULL COMMENT'商品小图列表',
	`pict_url` VARCHAR(512) NOT NULL COMMENT'商品主图',
	`item_url` VARCHAR(512) NOT NULL COMMENT'商品详情页连接地址',
	`coupon_total_count` INT(11) NOT NULL COMMENT'优惠券总量',
	`commission_rate` VARCHAR(8) NOT NULL COMMENT'佣金比率%',
	`coupon_info` VARCHAR(16) NOT NULL COMMENT'优惠券面额',
	`category` INT(11) NOT NULL COMMENT'后台一级类目',
	`num_iid` BIGINT(20) NOT NULL COMMENT'商品ID',
	`coupon_remain_count` INT(11) NOT NULL COMMENT'优惠券剩余量',
	`coupon_start_time` DATE NOT NULL COMMENT'优惠券开始时间',
	`coupon_end_time` DATE NOT NULL COMMENT'优惠券结束时间',
	`coupon_click_url` VARCHAR(512) COMMENT'商品优惠券推广链接',
	`item_description` VARCHAR(512) COMMENT'宝贝描述',
	UNIQUE KEY `UK_coupon_num_iid`(`num_iid`)
);