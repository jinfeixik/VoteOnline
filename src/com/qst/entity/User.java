package com.qst.entity;

public class User {
	public String toString() {
		return "User [VU_USER_ID=" + VU_USER_ID + ", VU_USER_NAME="
				+ VU_USER_NAME + ", VU_PASSWORD=" + VU_PASSWORD
				+ ", VU_STATUS=" + VU_STATUS + ", VU_VERSION=" + VU_VERSION
				+ "]";
	}
	private int VU_USER_ID;
	private String VU_USER_NAME;
	private String VU_PASSWORD;
	
	public int getVU_USER_ID() {
		return VU_USER_ID;
	}
	public void setVU_USER_ID(int vU_USER_ID) {
		VU_USER_ID = vU_USER_ID;
	}
	public String getVU_USER_NAME() {
		return VU_USER_NAME;
	}
	public void setVU_USER_NAME(String vU_USER_NAME) {
		VU_USER_NAME = vU_USER_NAME;
	}
	public String getVU_PASSWORD() {
		return VU_PASSWORD;
	}
	public void setVU_PASSWORD(String vU_PASSWORD) {
		VU_PASSWORD = vU_PASSWORD;
	}
	
	public String getVU_STATUS() {
		return VU_STATUS;
	}
	public void setVU_STATUS(String vU_STATUS) {
		VU_STATUS = vU_STATUS;
	}
	public int getVU_VERSION() {
		return VU_VERSION;
	}
	public void setVU_VERSION(int vU_VERSION) {
		VU_VERSION = vU_VERSION;
	}
	private String VU_STATUS;
	private int VU_VERSION;

}
