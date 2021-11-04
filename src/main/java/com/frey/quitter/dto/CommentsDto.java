package com.frey.quitter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Objects;


public class CommentsDto {
    private Long id;
    private Long postId;
    private Instant createdDate;
    private String text;
    private String userName;
	
    public CommentsDto() {
    	
    }
    
    public CommentsDto(Long id, Long postId, Instant createdDate, String text, String userName) {
		super();
		this.id = id;
		this.postId = postId;
		this.createdDate = createdDate;
		this.text = text;
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdDate, id, postId, text, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentsDto other = (CommentsDto) obj;
		return Objects.equals(createdDate, other.createdDate) && Objects.equals(id, other.id)
				&& Objects.equals(postId, other.postId) && Objects.equals(text, other.text)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "CommentsDto [id=" + id + ", postId=" + postId + ", createdDate=" + createdDate + ", text=" + text
				+ ", userName=" + userName + "]";
	}
    
	
    
}
