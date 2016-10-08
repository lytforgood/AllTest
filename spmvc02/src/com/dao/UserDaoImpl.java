package com.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.model.User;
import com.util.Page;
import com.util.PageUtil;
import com.util.Results;

@Repository
public class UserDaoImpl implements UserDao {
	@Resource
	private HibernateTemplate hibernateTemplate;

	public void add(User u) {
		hibernateTemplate.save(u);
	}

	public User login(User user) {
		String hql = "from User user where user.name='" + user.getName()
				+ "' and user.password='" + user.getPassword() + "'";
		List list = hibernateTemplate.find(hql);
		return (User) list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Results list(Page page) {
		List find = hibernateTemplate.find("select count(*) from User");
		page = PageUtil.createPage(page, ((Long) find.get(0)).intValue());
		final Page page2 = page;
		List<User> all = hibernateTemplate.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from User  order by id desc");
				// 设置每页显示多少个，设置多大结果。
				query.setMaxResults(page2.getEveryPage());
				// 设置起点
				query.setFirstResult(page2.getBeginIndex());
				return query.list();
			}

		});
		Results result = new Results();
		result.setPage(page2);
		result.setList(all);
		return result;
	}

	@Override
	public void delete(User user) {
		 hibernateTemplate.delete(user);
	}
	
	@SuppressWarnings("unchecked")
	//事务回滚
	public void callback(final User user) {
		// hibernateTemplate.delete(user);
		hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.delete(user);
				Query query = session
						.createQuery("from Userssd  order by id desc");
				return query.list();
			}

		});
	}

	// 执行原生态的SQL
	public void sql(User user) {
		// hibernateTemplate.delete(user);
		SessionFactory sf = hibernateTemplate.getSessionFactory();
		Session s = null;
		Transaction t = null;
		try {
			s = sf.openSession();
			t = s.beginTransaction();

			String sql = "SELECT id FROM user";
			List query = s.createSQLQuery(sql).list();
			t.commit();
			System.out.println(query.get(0));
		} catch (Exception err) {
			t.rollback();
			err.printStackTrace();
		} finally {
			s.close();
		}
	}

	@Override
	public User querybyid(int id) {
		String hql = "from User user where user.id='" + id + "'";
		List list = hibernateTemplate.find(hql);
		return (User) list.get(0);
	}

	@Override
	public void update(User user) {
		hibernateTemplate.update(user);
	}

}
