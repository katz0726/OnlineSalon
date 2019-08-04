package jp.co.salon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
public class Talk {

	@Id
	@NotNull
	@Column(name="group_id")
	private int group_id;

	@Id
	@NotNull
	@Column(name="talk_id")
	private int talk_id;

	@NotNull
	@Column(name="content")
	private String content;

	@Null
	@Column(name="attached_file")
	private String attachedFile;

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public int getTalk_id() {
		return talk_id;
	}

	public void setTalk_id(int talk_id) {
		this.talk_id = talk_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAttachedFile() {
		return attachedFile;
	}

	public void setAttachedFile(String attachedFile) {
		this.attachedFile = attachedFile;
	}

	@Override
	public String toString() {
		return "Talk [group_id=" + group_id + ", talk_id=" + talk_id + ", content=" + content + ", attachedFile="
				+ attachedFile + "]";
	}
}
