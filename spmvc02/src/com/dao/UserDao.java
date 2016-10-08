package com.dao;

import com.model.User;
import com.util.Page;
import com.util.Results;

public interface UserDao {

	void add(User user);

	User login(User user);

	Results list(Page page);

	void delete(User user);

	User querybyid(int id);

	void update(User user);

}
