package cn.tf.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.hibernate.classic.Session;
import org.junit.Test;

import cn.tf.domain.Book;
import cn.tf.domain.Category;
import cn.tf.domain.Person;
import cn.tf.utils.H3Utils;

public class TestDemo3 {
	
/*	@Test
	public void test1() throws Exception{
		
		Book book=new Book();
		book.setTitle("数据结构");
		book.setPrice("56.8");
	
		Session session=(Session) H3Utils.getCurrSession();
		session.beginTransaction();
		
		session.save(book);
		
		session.getTransaction().commit();
		
	}
	
	@Test
	public void test2() throws Exception{
		
		Book book=new Book();
		book.setBid(1);
		book.setTitle("云计算");
		//book.setPrice("56.8");
	
		Session session=(Session) H3Utils.getCurrSession();
		session.beginTransaction();
		
		session.update(book);
		
		session.getTransaction().commit();
		
	}

	@Test
	public void test3() throws Exception{
		

	
		Session session=(Session) H3Utils.getCurrSession();
		session.beginTransaction();
		
		Book book=(Book) session.get(Book.class, 4);
		book.setPrice("100");
		session.update(book);
		
		session.getTransaction().commit();
		
	}
	*/
	/*@Test
	public void test4() throws Exception{
		
		Session session=(Session) H3Utils.getCurrSession();
		session.beginTransaction();
		
		Book book=(Book) session.get(Book.class, 1);
		
		System.out.println(book);
		
		session.getTransaction().commit();
		//session.close();
	}*/
	
	
	@Test
	public void test5() throws Exception{
		
		Session session=(Session) H3Utils.getCurrSession();
		session.beginTransaction();
		
		Category category=new Category();
		category.setCname("sasa");
		
		session.save(category);
		
		
		session.getTransaction().commit();
		
	}
	
	
	

}
