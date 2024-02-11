package com.risheek.stou.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.risheek.stou.compositeKey.UserKey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
@IdClass(UserKey.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	
	@Id
	String email;
	@Id
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "role_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
	Role role;
	String picture;
	@Column(name = "first_name")
	String firstName;
	@Column(name = "last_name")
	String lastName;
	String password;
	String address;
	Double rating;
	@Column(name = "num_ratings")
	Integer numRatings;
	@Column(name = "about_me")
	String aboutMe;
	Boolean banned;
	@Column(name = "num_views")
	Integer numViews;
	@CreationTimestamp(source = SourceType.DB)
	Timestamp created;
	@UpdateTimestamp(source = SourceType.DB)
	Timestamp updated;
	public User() {
		super();
	}
	
	public User(String email, Role role, String password)  {
		this.email = email;
		this.role = role;
		this.password = password;
	}
	
	public User(String email, Role role, String picture, String firstName, String lastName, String password,
			String address, double rating, int numRatings, String aboutMe, boolean banned, int numViews,
			Timestamp created, Timestamp updated) {
		super();
		this.email = email;
		this.role = role;
		this.picture = picture;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.address = address;
		this.rating = rating;
		this.numRatings = numRatings;
		this.aboutMe = aboutMe;
		this.banned = banned;
		this.numViews = numViews;
		this.created = created;
		this.updated = updated;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getNumRatings() {
		return numRatings;
	}
	public void setNumRatings(int numRatings) {
		this.numRatings = numRatings;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public boolean isBanned() {
		return banned;
	}
	public void setBanned(boolean banned) {
		this.banned = banned;
	}
	public int getNumViews() {
		return numViews;
	}
	public void setNumViews(int numViews) {
		this.numViews = numViews;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", role=" + role + ", picture=" + picture + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", password=" + password + ", address=" + address + ", rating=" + rating
				+ ", numRatings=" + numRatings + ", aboutMe=" + aboutMe + ", banned=" + banned + ", numViews="
				+ numViews + ", created=" + created + ", updated=" + updated + "]";
	}
	
}
