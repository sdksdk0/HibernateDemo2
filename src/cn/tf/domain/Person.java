package cn.tf.domain;

import java.util.Arrays;
import java.util.Date;

public class Person {
	private Integer pid;
	private String name;
	private boolean gender;
	private int age;
	private byte[] photo;
	private String desc;
	
	private Date birthday;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", photo=" + Arrays.toString(photo)
				+ ", desc=" + desc + ", birthday=" + birthday + "]";
	}
	
	
	

}
