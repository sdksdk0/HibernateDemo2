package cn.tf.test;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import cn.tf.utils.H3Utils;

public class TestDemo1 {
	
	@Test
	public void test1(){
		Session session=(Session) H3Utils.openSession();
		
		Session session1=(Session) H3Utils.openSession();
		System.out.println(session==session1);
		
		
		session.close();
		session1.close();
	}
	
	@Test
	public void test2(){
		Session session=(Session) H3Utils.openSession();
		
		
		session.close();
		//session.close();
	}
	
	@Test
	public void test3(){
		Session session=(Session) H3Utils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		beginTransaction.commit();
		session.close();
	}
	

}
