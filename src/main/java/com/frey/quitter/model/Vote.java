package com.frey.quitter.model;

import lombok.Builder;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Objects;


@Entity
@Builder
public class Vote {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long voteId;
    private VoteType voteType;
    @NotNull
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "postId", referencedColumnName = "postId")
    private Post post;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
	
    public Vote() {
    	
    }
    
    public Vote(Long voteId, VoteType voteType, @NotNull Post post, User user) {
		super();
		this.voteId = voteId;
		this.voteType = voteType;
		this.post = post;
		this.user = user;
	}

	public Long getVoteId() {
		return voteId;
	}

	public void setVoteId(Long voteId) {
		this.voteId = voteId;
	}

	public VoteType getVoteType() {
		return voteType;
	}

	public void setVoteType(VoteType voteType) {
		this.voteType = voteType;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(post, user, voteId, voteType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vote other = (Vote) obj;
		return Objects.equals(post, other.post) && Objects.equals(user, other.user)
				&& Objects.equals(voteId, other.voteId) && voteType == other.voteType;
	}

	@Override
	public String toString() {
		return "Vote [voteId=" + voteId + ", voteType=" + voteType + ", post=" + post + ", user=" + user + "]";
	}
    
    
}
