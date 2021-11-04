package com.frey.quitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frey.quitter.dto.CommentsDto;
import com.frey.quitter.exception.PostNotFoundException;
import com.frey.quitter.mapper.CommentMapper;
import com.frey.quitter.model.Comment;
import com.frey.quitter.model.NotificationEmail;
import com.frey.quitter.model.Post;
import com.frey.quitter.model.User;
import com.frey.quitter.repository.CommentRepository;
import com.frey.quitter.repository.PostRepository;
import com.frey.quitter.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@Transactional
public class CommentService {

    //TODO: Construct POST URL
    private static final String POST_URL = "";

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthService authService;
    @Autowired
    private MailContentBuilder mailContentBuilder;
    @Autowired
    private MailService mailService;

    public void createComment(CommentsDto commentsDto) {
        Post post = postRepository.findById(commentsDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException(commentsDto.getPostId().toString()));
        Comment comment = commentMapper.map(commentsDto, post, authService.getCurrentUser());
        commentRepository.save(comment);

        String message = mailContentBuilder.build(authService.getCurrentUser().getUsername() + " posted a comment on your post : " + comment.getText() +  POST_URL);
        sendCommentNotification(post.getUser(),message, authService.getCurrentUser());
    }

    public List<CommentsDto> getCommentByPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId.toString()));
        return commentRepository.findByPost(post)
                .stream()
                .map(commentMapper::mapToDto)
                .collect(toList());
    }

    public List<CommentsDto> getCommentsByUser(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(userName));
        return commentRepository.findAllByUser(user)
                .stream()
                .map(commentMapper::mapToDto)
                .collect(toList());
    }

    private void sendCommentNotification( User userpost, String message,User user) {
        mailService.sendMail(new NotificationEmail(user.getUsername() + " Commented on your post", userpost.getEmail(), message));
    }
}
