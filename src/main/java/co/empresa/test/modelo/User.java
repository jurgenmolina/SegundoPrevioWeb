package co.empresa.test.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class User implements Serializable {
	
	
	private Integer id;
	
	private String username;
	
	private String password;
	
	private String email;

	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	
	
	
	
}
