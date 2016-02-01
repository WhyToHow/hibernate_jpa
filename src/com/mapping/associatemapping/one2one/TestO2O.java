package com.mapping.associatemapping.one2one;

import javax.persistence.EntityManager;

import com.utils.EntityManagerUtils;

public class TestO2O {
	public static void main(String[] args){
		User2 user = new User2();
		user.setUserName("张三");
		
		IdCard idCard = new IdCard();
		idCard.setCardNum("a001");
		idCard.setPlace("朝阳");
		idCard.setUser(user);
		
		EntityManager entityManager = EntityManagerUtils.getInstance();
		try{
			entityManager.persist(user);
			entityManager.persist(idCard);
			entityManager.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			entityManager.getEntityManagerFactory().close();
		}
		
	}

}
