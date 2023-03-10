package fpt.lab.model.dto;

import java.io.Serializable;

public class UserDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userId;
	private String userName;
	public UserDto(String userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserDto() {
	}
	
}
