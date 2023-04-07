package com.qst.entity;

import java.util.List;

public class SuOption {
	private Subject su;
	private List<Option> ops;
	public Subject getSu() {
		return su;
	}
	public void setSu(Subject su) {
		this.su = su;
	}
	public List<Option> getOps() {
		return ops;
	}
	public String toString() {
		return "SuOption [su=" + su + ", ops=" + ops + "]";
	}
	public void setOps(List<Option> ops) {
		this.ops = ops;
	}

}
