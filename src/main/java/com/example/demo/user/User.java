package com.example.demo.user;

import java.util.Objects;

public class User {
	  private Integer id;
	    private String firstName;
	    private String lastName;
	    private String mobileNum;
	    private String emailId;
	    private Role role;
	    private String username;
	    private String password;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
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

	    public String getMobileNum() {
	        return mobileNum;
	    }

	    public void setMobileNum(String mobileNum) {
	        this.mobileNum = mobileNum;
	    }

	    public String getEmailId() {
	        return emailId;
	    }

	    public void setEmailId(String emailId) {
	        this.emailId = emailId;
	    }

	    public Role getRole() {
	        return role;
	    }

	    public void setRole(Role role) {
	        this.role = role;
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

	    @Override
	    public int hashCode() {
	        int hash = 7;
	        hash = 37 * hash + Objects.hashCode(this.id);
	        hash = 37 * hash + Objects.hashCode(this.firstName);
	        hash = 37 * hash + Objects.hashCode(this.lastName);
	        hash = 37 * hash + Objects.hashCode(this.mobileNum);
	        hash = 37 * hash + Objects.hashCode(this.emailId);
	        hash = 37 * hash + Objects.hashCode(this.role);
	        hash = 37 * hash + Objects.hashCode(this.username);
	        hash = 37 * hash + Objects.hashCode(this.password);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final User other = (User) obj;
	        if (!Objects.equals(this.firstName, other.firstName)) {
	            return false;
	        }
	        if (!Objects.equals(this.lastName, other.lastName)) {
	            return false;
	        }
	        if (!Objects.equals(this.mobileNum, other.mobileNum)) {
	            return false;
	        }
	        if (!Objects.equals(this.emailId, other.emailId)) {
	            return false;
	        }
	        if (!Objects.equals(this.username, other.username)) {
	            return false;
	        }
	        if (!Objects.equals(this.password, other.password)) {
	            return false;
	        }
	        if (!Objects.equals(this.id, other.id)) {
	            return false;
	        }
	        if (this.role != other.role) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNum=" + mobileNum + ", emailId=" + emailId + ", role=" + role + ", username=" + username + ", password=" + password + '}';
	    }

}
