package com.chenyue.dao;

import java.util.List;

import com.chenyue.beans.NewsLabel;


public interface INewsLabelDao {
	List<NewsLabel> selectChildrenByParent(int pid);
	NewsLabel selectNewsLabelById(int id);
}
