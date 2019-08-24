package jp.co.salon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
public class User {
	@Id
	@NotNull
	@Column(name="user_id")
	private String user_id;

	@NotNull
	@Column(name="user_name")
	private String user_name;

	@NotNull
	@Column(name="email")
	private String email;

	@NotNull
	@Column(name="password")
	private String password;

	@Null
	@Column(name="search_id")
	private String search_id;


	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

	public String getSearchId() {
		return search_id;
	}
	public void setSearchId(String searchId) {
		this.search_id = searchId;
	}

	@Override
	public String toString() {
		return "LoginUser [userId=" + user_id + ", userName=" + user_name + ", email=" + email + ", password=" + password
				+ ", searchId=" + search_id + "]";
	}
}
