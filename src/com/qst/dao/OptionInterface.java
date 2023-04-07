package com.qst.dao;

import java.util.List;

import com.qst.entity.Option;
import com.qst.entity.Subject;
import com.qst.entity.User;

public interface OptionInterface {
	public void addOption(Option option);
	public List<Option> findOptions(Subject subjects);
	public void deleteOption(int VS_ID);
}
