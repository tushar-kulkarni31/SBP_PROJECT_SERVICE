package com.cognizant.fsd.sbaproject.mongodb.mongoDao;

import com.cognizant.fsd.sbaproject.model.ParentTask;

public interface ParentTaskDao {

	public void create(ParentTask parentTask);

	public void update(ParentTask parentTask);

	public void delete(ParentTask parentTask);

	public void deleteAll();

	public ParentTask find(ParentTask parentTask);

}