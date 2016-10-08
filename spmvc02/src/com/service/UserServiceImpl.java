package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.model.User;
import com.util.Page;
import com.util.Results;


@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	

	public void add(User user) {
		userDao.add(user);
	}

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public Results list(Page page) {
		return userDao.list(page);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public User querybyid(int id) {
		return userDao.querybyid(id);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}


	
}
