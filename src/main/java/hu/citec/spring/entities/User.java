package hu.citec.spring.entities;

public class User {

	private int id;
	private String fullName;
	private String userName;
	private String userPassword;
	
	public User() {
	}
	
	public User(int id, String fullName, String userName, String userPassword) {
		this.id = id;
		this.fullName = fullName;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}
}