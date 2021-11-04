package com.frey.quitter.model;


import lombok.Builder;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long postId;
    @NotBlank(message = "Post Name cannot be empty or Null")
    private String postName;
    @Nullable
    private String url;
    @Nullable
    @Lob
    private String description;
    private Integer voteCount = 0;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
    private Instant createdDate;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private SubQuitter subQuitter;
	
    public Post() {
    	
    }
    
    public Post(Long postId, @NotBlank(message = "Post Name cannot be empty or Null") String postName, String url,
			String description, Integer voteCount, User user, Instant createdDate, SubQuitter subQuitter) {
		super();
		this.postId = postId;
		this.postName = postName;
		this.url = url;
		this.description = description;
		this.voteCount = voteCount;
		this.user = user;
		this.createdDate = createdDate;
		this.subQuitter = subQuitter;
	}
    
    public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Instant getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}
	public SubQuitter getSubQuitter() {
		return subQuitter;
	}
	public void setSubQuitter(SubQuitter subQuitter) {
		this.subQuitter = subQuitter;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdDate, description, postId, postName, subQuitter, url, user, voteCount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(createdDate, other.createdDate) && Objects.equals(description, other.description)
				&& Objects.equals(postId, other.postId) && Objects.equals(postName, other.postName)
				&& Objects.equals(subQuitter, other.subQuitter) && Objects.equals(url, other.url)
				&& Objects.equals(user, other.user) && Objects.equals(voteCount, other.voteCount);
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postName=" + postName + ", url=" + url + ", description=" + description
				+ ", voteCount=" + voteCount + ", user=" + user + ", createdDate=" + createdDate + ", subQuitter="
				+ subQuitter + "]";
	}
	
	
    
}
