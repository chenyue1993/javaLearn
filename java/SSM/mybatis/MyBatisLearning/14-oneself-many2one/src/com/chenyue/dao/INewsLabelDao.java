package com.chenyue.dao;

import java.util.List;

import com.chenyue.beans.NewsLabel;


public interface INewsLabelDao {
	NewsLabel selectMyself(int id);
	NewsLabel selectParentByChild(int pid);
	NewsLabel selectNewsLabelById(int id);
}
