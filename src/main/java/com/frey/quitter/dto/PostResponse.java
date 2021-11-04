package com.frey.quitter.dto;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PostResponse {
    private Long id;
    private String postName;
    private String url;
    private String description;
    private String userName;
    private String subQuitterName;
    private Integer voteCount;
    private Integer commentCount;
    private String duration;
    private boolean upVote;
    private boolean downVote;
    
    public PostResponse() {
    	
    }
    
	public PostResponse(Long id, String postName, String url, String description, String userName, String subQuitterName,
			Integer voteCount, Integer commentCount, String duration, boolean upVote, boolean downVote) {
		super();
		this.id = id;
		this.postName = postName;
		this.url = url;
		this.description = description;
		this.userName = userName;
		this.subQuitterName = subQuitterName;
		this.voteCount = voteCount;
		this.commentCount = commentCount;
		this.duration = duration;
		this.upVote = upVote;
		this.downVote = downVote;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSubQuitterName() {
		return subQuitterName;
	}

	public void setSubQuitterName(String subQuitterName) {
		this.subQuitterName = subQuitterName;
	}

	public Integer getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public boolean isUpVote() {
		return upVote;
	}

	public void setUpVote(boolean upVote) {
		this.upVote = upVote;
	}

	public boolean isDownVote() {
		return downVote;
	}

	public void setDownVote(boolean downVote) {
		this.downVote = downVote;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commentCount, description, downVote, duration, id, postName, subQuitterName, upVote, url,
				userName, voteCount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostResponse other = (PostResponse) obj;
		return Objects.equals(commentCount, other.commentCount) && Objects.equals(description, other.description)
				&& downVote == other.downVote && Objects.equals(duration, other.duration)
				&& Objects.equals(id, other.id) && Objects.equals(postName, other.postName)
				&& Objects.equals(subQuitterName, other.subQuitterName) && upVote == other.upVote
				&& Objects.equals(url, other.url) && Objects.equals(userName, other.userName)
				&& Objects.equals(voteCount, other.voteCount);
	}

	@Override
	public String toString() {
		return "PostResponse [id=" + id + ", postName=" + postName + ", url=" + url + ", description=" + description
				+ ", userName=" + userName + ", subQuitterName=" + subQuitterName + ", voteCount=" + voteCount
				+ ", commentCount=" + commentCount + ", duration=" + duration + ", upVote=" + upVote + ", downVote="
				+ downVote + "]";
	}
    
    
}
