package com.frey.quitter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

import javax.validation.constraints.NotBlank;


public class LogoutRequest {
    @NotBlank
    private String refreshToken;

    public LogoutRequest() {
    	
    }
    
	public LogoutRequest(@NotBlank String refreshToken) {
		super();
		this.refreshToken = refreshToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@Override
	public int hashCode() {
		return Objects.hash(refreshToken);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogoutRequest other = (LogoutRequest) obj;
		return Objects.equals(refreshToken, other.refreshToken);
	}

	@Override
	public String toString() {
		return "LogoutRequest [refreshToken=" + refreshToken + "]";
	}
	
	


    
}
