package com.frey.quitter.dto;

import java.util.Objects;

import com.frey.quitter.model.VoteType;


public class VoteDto {
    private VoteType voteType;
    private Long postId;
    
    public VoteDto() {
    	
    }
    
	public VoteDto(VoteType voteType, Long postId) {
		super();
		this.voteType = voteType;
		this.postId = postId;
	}

	public VoteType getVoteType() {
		return voteType;
	}

	public void setVoteType(VoteType voteType) {
		this.voteType = voteType;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(postId, voteType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoteDto other = (VoteDto) obj;
		return Objects.equals(postId, other.postId) && voteType == other.voteType;
	}

	@Override
	public String toString() {
		return "VoteDto [voteType=" + voteType + ", postId=" + postId + "]";
	}
    
	
    
}
