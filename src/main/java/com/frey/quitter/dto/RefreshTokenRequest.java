package com.frey.quitter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

import javax.validation.constraints.NotBlank;


public class RefreshTokenRequest {
    @NotBlank
    private String refreshToken;
    private String username;
    
    public RefreshTokenRequest() {
    	
    }
	public RefreshTokenRequest(@NotBlank String refreshToken, String username) {
		super();
		this.refreshToken = refreshToken;
		this.username = username;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public int hashCode() {
		return Objects.hash(refreshToken, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RefreshTokenRequest other = (RefreshTokenRequest) obj;
		return Objects.equals(refreshToken, other.refreshToken) && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "RefreshTokenRequest [refreshToken=" + refreshToken + ", username=" + username + "]";
	}
    
    
}
