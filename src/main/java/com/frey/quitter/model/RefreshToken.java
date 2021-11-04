package com.frey.quitter.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Objects;


@Entity
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private Instant createdDate;
	
    public RefreshToken() {
    	
    }
    
    public RefreshToken(Long id, String token, Instant createdDate) {
		super();
		this.id = id;
		this.token = token;
		this.createdDate = createdDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Instant getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdDate, id, token);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RefreshToken other = (RefreshToken) obj;
		return Objects.equals(createdDate, other.createdDate) && Objects.equals(id, other.id)
				&& Objects.equals(token, other.token);
	}

	@Override
	public String toString() {
		return "RefreshToken [id=" + id + ", token=" + token + ", createdDate=" + createdDate + "]";
	}
    
	
    
}
