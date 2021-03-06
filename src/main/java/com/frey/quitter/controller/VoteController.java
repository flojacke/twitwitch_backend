package com.frey.quitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frey.quitter.dto.VoteDto;
import com.frey.quitter.service.VoteService;

@RestController 
@RequestMapping("/api/votes/") 

public class VoteController { 

	@Autowired
    private VoteService voteService;

    @PostMapping
    public ResponseEntity<Void> vote(@RequestBody VoteDto voteDto) { 
        voteService.vote(voteDto); 
        return new ResponseEntity<>(HttpStatus.OK ); 
    } 
}