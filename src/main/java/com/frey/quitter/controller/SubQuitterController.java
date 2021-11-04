package com.frey.quitter.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frey.quitter.dto.SubQuitterDto;
import com.frey.quitter.service.SubQuitterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/subquitter")
@Slf4j
public class SubQuitterController {

	@Autowired
    private SubQuitterService subQuitterService;

    @PostMapping
    public ResponseEntity<SubQuitterDto> createSubQuitter(@RequestBody SubQuitterDto subQuitterDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subQuitterService.save(subQuitterDto));
    }

    @GetMapping
    public ResponseEntity<List<SubQuitterDto>> getAllSubQuitters() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(subQuitterService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubQuitterDto> getSubQuitter(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(subQuitterService.getSubQuitter(id));
    }
}
