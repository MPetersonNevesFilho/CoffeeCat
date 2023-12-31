package tqs.coffeeCat.payload.request;

import org.springframework.data.mongodb.core.mapping.Field;

public class LoginRequest {
	@Field("username")
	private String username;
	@Field("password")
	private String password;

	public LoginRequest(String string, String string2) {
		this.username = string;
		this.password = string2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
