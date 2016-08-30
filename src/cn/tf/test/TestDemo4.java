package cn.tf.test;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import cn.tf.domain.Category;
import cn.tf.utils.H3Utils;

public class TestDemo4 {
	
	@Test
	public void test1(){
		Session session=(Session) H3Utils.openSession();
		session.beginTransaction();
		
		Category category=(Category) session.get(Category.class, "213243-2132-321");
		System.out.println(category);
		
		session.getTransaction().commit();
		
		session.close();
	}
	

}
