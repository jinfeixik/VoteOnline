package com.qst.dao;

import java.util.List;

import com.qst.entity.Subject;


public interface SubjectInterface {
	public List<Subject> findSubjects(int id);
	public void addSubject(Subject subject);
	public void deleteSubject(int VS_ID);
	public List<Subject> findSub(String VS_TITLE,int id);
}
