package cn.tf.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.hibernate.classic.Session;
import org.junit.Test;

import cn.tf.domain.Person;
import cn.tf.utils.H3Utils;

public class TestDemo2 {
	
	@Test
	public void test1() throws Exception{
		
		FileInputStream  is=new FileInputStream("f.jpg");
		byte[] photo=new byte[is.available()];
		is.read(photo);
		is.close();
		
		Person person=new Person();
		person.setGender(true); 
		person.setAge(21);
		person.setPhoto(photo);
		person.setBirthday(new Date());
		person.setDesc("这个应该描述，哦吼吼");
		
		
		Session session=(Session) H3Utils.getCurrSession();
		session.beginTransaction();
		
		session.save(person);
		
		
		session.getTransaction().commit();
		
		
		
		
		
	}

}
