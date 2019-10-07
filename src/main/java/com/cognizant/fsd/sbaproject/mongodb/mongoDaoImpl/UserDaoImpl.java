package com.cognizant.fsd.sbaproject.mongodb.mongoDaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.fsd.sbaproject.model.User;
import com.cognizant.fsd.sbaproject.mongodb.mongoDao.UserDao;

@Repository
@Qualifier("UserDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	MongoTemplate mongoTemplate;

	final String COLLECTION = "user";

	public void create(User user) {
		mongoTemplate.insert(user);
	}

	public void update(User user) {
		mongoTemplate.save(user);
	}

	public void delete(User user) {
		mongoTemplate.remove(user);
	}

	public void deleteAll() {
		mongoTemplate.remove(new Query(), COLLECTION);
	}

	public User find(User user) {
		Query query = new Query(Criteria.where("_id").is(user.getUserId()));
		return mongoTemplate.findOne(query, User.class);
	}
	
	public List<User> findAll() {
		return mongoTemplate.findAll(User.class);
	}
}