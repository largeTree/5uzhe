package com.qiuxs.movie.utils;

/**
 * 电影获取方式
 * @author qiuxs
 *
 */
public enum MovieGetWayType {

	ED2K("电驴链接"),
	MAGNET("磁力链接"),
	THUNDER("迅雷链接"),
	BAIDU("百度云地址"),
	TORRENT("种子");

	private String name;

	MovieGetWayType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return new StringBuilder(super.name()).append(":").append(this.name).toString();
	}

}
