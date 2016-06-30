package com.lg.gz.test;

import com.lg.gz.dao.UserDao;
import com.lg.gz.domain.User1;
import com.lg.gz.domain.User2;

public class TestDemo {

	public static void main(String[] args) {
		User1 user1 = new User1();
		user1.setId(10); // 设置查询的ID
		user1.setCity("深圳");

		User1 user2 = new User1();
		user2.setUserName("lige");

		User1 user3 = new User1();
		user3.setEmail("liu@sina.com, zh@163.com, 7878@qq.com"); // 查询符合其中之一即可

		UserDao userDao = new UserDao();

		String sql1 = userDao.query(user1);
		String sql2 = userDao.query(user2);
		String sql3 = userDao.query(user3);

		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);
		
		User2 user21 = new User2();
		user21.setId(10); // 设置查询的ID
		user21.setCity("深圳");

		User2 user22 = new User2();
		user22.setUserName("lige");
		user22.setMobile("25487985643");

		User2 user23 = new User2();
		user23.setEmail("liu@sina.com, zh@163.com, 7878@qq.com"); // 查询符合其中之一即可
		user23.setMobile("18306824330");
		
		String sql21 = userDao.query(user21);
		String sql22 = userDao.query(user22);
		String sql23 = userDao.query(user23);
		
		System.out.println(sql21);
		System.out.println(sql22);
		System.out.println(sql23);


	}

}
