package com.frey.quitter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frey.quitter.dto.VoteDto;
import com.frey.quitter.exception.PostNotFoundException;
import com.frey.quitter.exception.SpringQuitterException;
import com.frey.quitter.model.Post;
import com.frey.quitter.model.Vote;
import com.frey.quitter.repository.PostRepository;
import com.frey.quitter.repository.VoteRepository;

import static com.frey.quitter.model.VoteType.UPVOTE;

@Service
public class VoteService {

	@Autowired
    private VoteRepository voteRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private AuthService authService;

    @Transactional
    public void vote(VoteDto voteDto) {
        Post post = postRepository.findById(voteDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException("Post Not Found with ID - " + voteDto.getPostId()));
        Optional<Vote> voteByPostAndUser = voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post, authService.getCurrentUser());
        if (voteByPostAndUser.isPresent() &&
                voteByPostAndUser.get().getVoteType()
                        .equals(voteDto.getVoteType())) {
            throw new SpringQuitterException("You have already "
                    + voteDto.getVoteType() + "'d for this post");
        }
        if (UPVOTE.equals(voteDto.getVoteType())) {
            post.setVoteCount(post.getVoteCount() + 1);
        } else {
            post.setVoteCount(post.getVoteCount() - 1);
        }
        voteRepository.save(mapToVote(voteDto, post));
        postRepository.save(post);
    }

    private Vote mapToVote(VoteDto voteDto, Post post) {
        return Vote.builder()
                .voteType(voteDto.getVoteType())
                .post(post)
                .user(authService.getCurrentUser())
                .build();
    }
}