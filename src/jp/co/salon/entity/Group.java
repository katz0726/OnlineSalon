package jp.co.salon.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Group {
	@Id
	@NotNull
	@Column(name="group_id")
	private int group_id;

	@NotNull
	@Size(max=80)
	@Column(name="group_name")
	private String group_name;

	@Column(name="modified")
	private Date modified;

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "Group [group_id=" + group_id + ", group_name=" + group_name
				+ ", modified=" + modified + "]";
	}
}
