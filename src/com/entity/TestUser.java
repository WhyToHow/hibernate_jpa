package com.entity;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestUser {
	public static void main(String[] args){
		
		//创建EntityManagerFactory对象 Persistence的静态方法 传入persistence.xml配置文件中的持久化单元名字
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		//通过工厂对象 获取entityManager对象 类似于hibernate中的session对象
		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.joinTransaction();
		
		try{
			//开启事务 否则报错
			entityManager.getTransaction().begin();//Transaction not active
			
			User user = new User();
			user.setUserName("李四");
			user.setMyDate(new Date());
			
			entityManager.persist(user);
			
			User userFind = entityManager.find(User.class, 53);
			System.out.println(userFind.getMyDate());
			entityManager.getTransaction().commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			
			entityManager.close();
			entityManagerFactory.close();
		}
		
	}
}
