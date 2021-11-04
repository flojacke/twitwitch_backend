package com.frey.quitter.dto;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PostRequest {
    private Long postId;
    private String subQuitterName;
    private String postName;
    private String url;
    private String description;
    
    public PostRequest() {
    	
    }
    
	public PostRequest(Long postId, String subQuitterName, String postName, String url, String description) {
		super();
		this.postId = postId;
		this.subQuitterName = subQuitterName;
		this.postName = postName;
		this.url = url;
		this.description = description;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getSubQuitterName() {
		return subQuitterName;
	}

	public void setSubQuitterName(String subQuitterName) {
		this.subQuitterName = subQuitterName;
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

	@Override
	public int hashCode() {
		return Objects.hash(description, postId, postName, subQuitterName, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostRequest other = (PostRequest) obj;
		return Objects.equals(description, other.description) && Objects.equals(postId, other.postId)
				&& Objects.equals(postName, other.postName) && Objects.equals(subQuitterName, other.subQuitterName)
				&& Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "PostRequest [postId=" + postId + ", subQuitterName=" + subQuitterName + ", postName=" + postName
				+ ", url=" + url + ", description=" + description + "]";
	}
    
    
}
