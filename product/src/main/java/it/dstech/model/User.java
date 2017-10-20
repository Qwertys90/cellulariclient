package it.dstech.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
@Id
@GeneratedValue
private int id;

private String username;

private String password;

@Enumerated(EnumType.STRING)
private UserProfileType profileType;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public UserProfileType getProfileType() {
	return profileType;
}
public void setProfileType(UserProfileType profileType) {
	this.profileType = profileType;
}
@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", profileType=" + profileType
			+ "]";
}


}
