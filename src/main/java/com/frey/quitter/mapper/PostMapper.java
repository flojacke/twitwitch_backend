package com.frey.quitter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.frey.quitter.dto.PostRequest;
import com.frey.quitter.dto.PostResponse;
import com.frey.quitter.model.Post;
import com.frey.quitter.model.SubQuitter;
import com.frey.quitter.model.User;
import com.frey.quitter.model.Vote;
import com.frey.quitter.model.VoteType;
import com.frey.quitter.repository.CommentRepository;
import com.frey.quitter.repository.VoteRepository;
import com.frey.quitter.service.AuthService;

import com.github.marlonlom.utilities.timeago.TimeAgo;

import static com.frey.quitter.model.VoteType.DOWNVOTE;
import static com.frey.quitter.model.VoteType.UPVOTE;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class PostMapper {

	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private VoteRepository voteRepository;
	@Autowired
	private AuthService authService;

	@Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
	@Mapping(target = "description", source = "postRequest.description")
	@Mapping(target = "subQuitter", source = "subQuitter")
	@Mapping(target = "voteCount", constant = "0")
	@Mapping(target = "user", source = "user")
	public abstract Post map(PostRequest postRequest, SubQuitter subQuitter, User user);

	@Mapping(target = "id", source = "postId")
	@Mapping(target = "subQuitterName", source = "subQuitter.name")
	@Mapping(target = "userName", source = "user.username")
	@Mapping(target = "commentCount", expression = "java(commentCount(post))")
	@Mapping(target = "duration", expression = "java(getDuration(post))")
	@Mapping(target = "upVote", expression = "java(isPostUpVoted(post))")
	@Mapping(target = "downVote", expression = "java(isPostDownVoted(post))")
	public abstract PostResponse mapToDto(Post post);

	Integer commentCount(Post post) {
		return commentRepository.findByPost(post).size();
	}

	String getDuration(Post post) {
		return TimeAgo.using(post.getCreatedDate().toEpochMilli());
	}

	boolean isPostUpVoted(Post post) {
		return checkVoteType(post, UPVOTE);
	}

	boolean isPostDownVoted(Post post) {
		return checkVoteType(post, DOWNVOTE);
	}

	private boolean checkVoteType(Post post, VoteType voteType) {
		if (authService.isLoggedIn()) {
			Optional<Vote> voteForPostByUser = voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post,
					authService.getCurrentUser());
			return voteForPostByUser.filter(vote -> vote.getVoteType().equals(voteType)).isPresent();
		}
		return false;
	}
}