package jp.co.salon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@Column(name="user_id")
	private int user_id;

	@Column(name="user_name")
	private String user_name;

	@Column(name="gender")
	private int gender;

	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;

	@Column(name="search_id")
	private String search_id;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSearch_id() {
		return search_id;
	}

	public void setSearch_id(String search_id) {
		this.search_id = search_id;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", gender=" + gender + ", email=" + email
				+ ", password=" + password + ", search_id=" + search_id + "]";
	}
}
