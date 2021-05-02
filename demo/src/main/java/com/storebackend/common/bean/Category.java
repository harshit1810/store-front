package com.storebackend.common.bean;

import java.io.Serializable;

public class Category implements Serializable {

	private String name;
	private String description;
	private String[] images;
	private String[] banners;
	private boolean published;
	private int level;
	private String parent;
}
