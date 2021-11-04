package com.frey.quitter.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frey.quitter.dto.SubQuitterDto;
import com.frey.quitter.exception.SubQuitterNotFoundException;
import com.frey.quitter.mapper.SubQuitterMapper;
import com.frey.quitter.model.SubQuitter;
import com.frey.quitter.repository.SubQuitterRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SubQuitterService {

	@Autowired
    private SubQuitterRepository subQuitterRepository;
//	@Autowired
//    private AuthService authService;
	@Autowired
	private SubQuitterMapper subQuitterMapper;

    @Transactional(readOnly = true)
    public List<SubQuitterDto> getAll() {
        return subQuitterRepository.findAll()
                .stream()
                //.map(this::mapToDto)
                .map(subQuitterMapper::mapSubQuitterToDto)
                .collect(toList());
    }

    @Transactional
    public SubQuitterDto save(SubQuitterDto subQuitterDto) {
        SubQuitter subQuitter = subQuitterRepository.save(subQuitterMapper.mapDtoToSubQuitter(subQuitterDto));
        //.save(mapToSubQuitter(subQuitterDto));
        subQuitterDto.setId(subQuitter.getId());
        return subQuitterDto;
    }

    @Transactional(readOnly = true)
    public SubQuitterDto getSubQuitter(Long id) {
        SubQuitter subQuitter = subQuitterRepository.findById(id)
                .orElseThrow(() -> new SubQuitterNotFoundException("SubQuitter not found with id -" + id));
        return subQuitterMapper.mapSubQuitterToDto(subQuitter);
        		//mapToDto(subQuitter);
    }

//    private SubQuitterDto mapToDto(SubQuitter subQuitter) {
//        return SubQuitterDto.builder().name(subQuitter.getName())
//                .id(subQuitter.getId())
//                .numberOfPosts(subQuitter.getPosts().size())
//                .build();
//    }

//    private SubQuitter mapToSubQuitter(SubQuitterDto subQuitterDto) {
//        return SubQuitter.builder().name("/r/" + subQuitterDto.getName())
//                .description(subQuitterDto.getDescription())
//                .user(authService.getCurrentUser())
//                .createdDate(Instant.now()).build();
//    }
}
