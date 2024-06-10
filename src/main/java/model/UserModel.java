package model;

public class UserModel {

	private String username;
	private String address;
	private String contact;
	private String email;
	private String password;

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(String username, String address, String contact, String email, String password) {
		super();
		this.username = username;
		this.address = address;
		this.contact = contact;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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

	@Override
	public String toString() {
		return "UserModel [username=" + username + ", address=" + address + ", contact=" + contact + ", email=" + email
				+ ", password=" + password + "]";
	}

}
