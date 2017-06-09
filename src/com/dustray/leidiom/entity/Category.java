package com.dustray.leidiom.entity;

public class Category {

	private String name;// 类别名称

	private int imageId;// 类别对应的图片

	public Category(String name, int imageId) {
		super();
		this.name = name;
		this.imageId = imageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

}
