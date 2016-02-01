package com.operate;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mapping.associatemapping.one2one.User2;
import com.utils.EntityManagerUtils;

public class Operate {
	public static void main(String args[]){
		EntityManager entityManager = EntityManagerUtils.getInstance();
		try{
			User2 user = null;
			String sql = "select t from User2 t";
			Query query = entityManager.createQuery(sql);
			//方法基本类似于Hibernate的方法
			//连接查询 使用本实体类的映射字段 select t from User t left join t.class c where...
			//getResultList 方法获取结果列表
			List<User2> list = (List<User2>)query.getResultList();
			Iterator it = list.iterator();
			while(it.hasNext()){
				user = (User2)it.next();
				System.out.println(user.getUserName()+" "+user.getIdCard().getCardNum());
			}
			
			entityManager.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			entityManager.getEntityManagerFactory().close();
		}
	}

}
