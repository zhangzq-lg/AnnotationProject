package com.lg.gz.domain;

import com.lg.gz.annotation.Column;
import com.lg.gz.annotation.Table;

@Table("user2")
public class User2 {

	@Column("id")
	private int id;

	@Column("user")
	private String userName;

	@Column("age")
	private int age;

	@Column("city")
	private String city;

	@Column("phone")
	private String mobile;

	@Column("email")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", age=" + age + ", city=" + city + ", mobile=" + mobile
				+ ", email=" + email + "]";
	}

}
