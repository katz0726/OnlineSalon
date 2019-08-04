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
	private int groupId;

	@NotNull
	@Size(max=80)
	@Column(name="group_name")
	private String groupName;

	@Column(name="modified")
	private Date modified;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + ", modified=" + modified + "]";
	}
}
