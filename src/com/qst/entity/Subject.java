package com.qst.entity;

public class Subject {
	private int VS_ID;
	private String VS_TITLE;
	private int VS_TYPE;
	private Integer num;
	private int flag=0;
	private int x=0;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	private String VU_USER_NAME;
	public int getVS_ID() {
		return VS_ID;
	}
	public String getVU_USER_NAME() {
		return VU_USER_NAME;
	}
	public void setVU_USER_NAME(String vU_USER_NAME) {
		VU_USER_NAME = vU_USER_NAME;
	}
	public void setVS_ID(int vS_ID) {
		VS_ID = vS_ID;
	}
	public String getVS_TITLE() {
		return VS_TITLE;
	}
	public void setVS_TITLE(String vS_TITLE) {
		VS_TITLE = vS_TITLE;
	}
	public int getVS_TYPE() {
		return VS_TYPE;
	}
	public void setVS_TYPE(int vS_TYPE) {
		VS_TYPE = vS_TYPE;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	

}
