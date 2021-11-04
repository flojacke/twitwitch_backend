package com.frey.quitter.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frey.quitter.model.Post;
import com.frey.quitter.model.SubQuitter;
import com.frey.quitter.model.User;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubQuitter(SubQuitter subQuitter);

    List<Post> findByUser(User user);
}
