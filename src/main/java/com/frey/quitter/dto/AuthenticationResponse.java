package com.frey.quitter.dto;

import java.time.Instant;
import java.util.Objects;

import lombok.Builder;


@Builder
public class AuthenticationResponse {
    private String authenticationToken;
    private String refreshToken;
    private Instant expiresAt;
    private String username;
	
    public AuthenticationResponse() {
    	
    }
    public AuthenticationResponse(String authenticationToken, String username) {
    	super();
    	this.authenticationToken = authenticationToken;
		this.username = username;
    }
    
    public AuthenticationResponse(String authenticationToken, String refreshToken, Instant expiresAt, String username) {
		super();
		this.authenticationToken = authenticationToken;
		this.refreshToken = refreshToken;
		this.expiresAt = expiresAt;
		this.username = username;
	}

	public String getAuthenticationToken() {
		return authenticationToken;
	}

	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Instant getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Instant expiresAt) {
		this.expiresAt = expiresAt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authenticationToken, expiresAt, refreshToken, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthenticationResponse other = (AuthenticationResponse) obj;
		return Objects.equals(authenticationToken, other.authenticationToken)
				&& Objects.equals(expiresAt, other.expiresAt) && Objects.equals(refreshToken, other.refreshToken)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "AuthenticationResponse [authenticationToken=" + authenticationToken + ", refreshToken=" + refreshToken
				+ ", expiresAt=" + expiresAt + ", username=" + username + "]";
	}
    
    
}
