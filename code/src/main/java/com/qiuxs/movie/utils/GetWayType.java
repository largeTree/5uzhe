package com.qiuxs.movie.utils;

/**
 * 电影获取方式
 * @author qiuxs
 *
 */
public enum GetWayType {

	ED2K(1, "电驴链接"),
	MAGNET(2, "磁力链接"),
	THUNDER(3, "迅雷链接"),
	BAIDU(4, "百度云地址"),
	TORRENT(5, "种子");

	private int val;
	private String name;

	GetWayType(int val, String name) {
		this.val = val;
		this.name = name;
	}

	public int getVal() {
		return this.val;
	}

	public String getName() {
		return this.name;
	}

}
