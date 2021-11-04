package com.frey.quitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frey.quitter.dto.PostRequest;
import com.frey.quitter.dto.PostResponse;
import com.frey.quitter.exception.PostNotFoundException;
import com.frey.quitter.exception.SubQuitterNotFoundException;
import com.frey.quitter.mapper.PostMapper;
import com.frey.quitter.model.Post;
import com.frey.quitter.model.SubQuitter;
import com.frey.quitter.model.User;
import com.frey.quitter.repository.PostRepository;
import com.frey.quitter.repository.SubQuitterRepository;
import com.frey.quitter.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@Transactional
public class PostService {

	@Autowired
    private  PostRepository postRepository;
	@Autowired
	private  SubQuitterRepository subQuitterRepository;
	@Autowired
	private  UserRepository userRepository;
	@Autowired
	private  AuthService authService;
	@Autowired
	private  PostMapper postMapper;

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }

    public void save(PostRequest postRequest) {
        SubQuitter subQuitter = subQuitterRepository.findByName(postRequest.getSubQuitterName())
                .orElseThrow(() -> new SubQuitterNotFoundException(postRequest.getSubQuitterName()));
        postRepository.save(postMapper.map(postRequest, subQuitter, authService.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsBySubQuitter(Long subQuitterId) {
    	SubQuitter subQuitter = subQuitterRepository.findById(subQuitterId)
                .orElseThrow(() -> new SubQuitterNotFoundException(subQuitterId.toString()));
        List<Post> posts = postRepository.findAllBySubQuitter(subQuitter);
        return posts.stream().map(postMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }
}