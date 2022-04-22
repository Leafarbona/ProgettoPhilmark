package it.philmark.docenza.payload.response;

import it.philmark.docenza.models.ESex;

import java.util.Date;
import java.util.List;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private Date dateOfBirth;
	private ESex sex;
	private List<String> roles;

	public JwtResponse(String accessToken, Long id, String username, String email, Date dateOfBirth, ESex sex, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public ESex getSex() {
		return sex;
	}

	public void setSex(ESex sex) {
		this.sex = sex;
	}
}