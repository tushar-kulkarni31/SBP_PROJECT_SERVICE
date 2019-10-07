package com.cognizant.fsd.sbaproject.mongodb.mongoDao;


import java.util.List;

import com.cognizant.fsd.sbaproject.model.User;

public interface UserDao {

	public void create(User user);

	public void update(User user);

	public void delete(User user);

	public void deleteAll();

	public User find(User user);
	
	public List<User> findAll();

}