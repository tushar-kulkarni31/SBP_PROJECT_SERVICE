package com.cognizant.fsd.sbaproject.mongodb.mongoDaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.fsd.sbaproject.model.Task;
import com.cognizant.fsd.sbaproject.mongodb.mongoDao.TaskDao;

@Repository
@Qualifier("TaskDao")
public class TaskDaoImpl implements TaskDao{
	
	@Autowired
	MongoTemplate mongoTemplate;

	final String COLLECTION = "task";

	public void create(Task task) {
		mongoTemplate.insert(task);
	}

	public void update(Task task) {
		mongoTemplate.save(task);
	}

	public void delete(Task task) {
		mongoTemplate.remove(task);
	}

	public void deleteAll() {
		mongoTemplate.remove(new Query(), COLLECTION);
	}

	public Task find(Task task) {
		Query query = new Query(Criteria.where("_id").is(task.getTaskId()));
		return mongoTemplate.findOne(query, Task.class);
	}
	
	public List<Task> findAll() {
		List<Task>  tasksList = mongoTemplate.findAll(Task.class);
		return tasksList;
	}

}
