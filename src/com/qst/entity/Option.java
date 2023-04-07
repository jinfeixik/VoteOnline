package com.qst.entity;

public class Option {
	private int VO_ID;
	private String VO_OPTION;
	private int VS_ID;
	private Integer sum;
	private int VO_ORDER;
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	
	public int getVO_ID() {
		return VO_ID;
	}
	public void setVO_ID(int vO_ID) {
		VO_ID = vO_ID;
	}
	public String getVO_OPTION() {
		return VO_OPTION;
	}
	public void setVO_OPTION(String vO_OPTION) {
		VO_OPTION = vO_OPTION;
	}
	public int getVS_ID() {
		return VS_ID;
	}
	public void setVS_ID(int vS_ID) {
		VS_ID = vS_ID;
	}
	public int getVO_ORDER() {
		return VO_ORDER;
	}
	public void setVO_ORDER(int vO_ORDER) {
		VO_ORDER = vO_ORDER;
	}
	@Override
	public String toString() {
		return "Option [VO_ID=" + VO_ID + ", VO_OPTION=" + VO_OPTION
				+ ", VS_ID=" + VS_ID + ", VO_ORDER=" + VO_ORDER + "]";
	}

}
