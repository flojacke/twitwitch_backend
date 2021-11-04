package com.frey.quitter.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.frey.quitter.dto.SubQuitterDto;
import com.frey.quitter.model.Post;
import com.frey.quitter.model.SubQuitter;


@Mapper(componentModel = "spring")
public interface SubQuitterMapper {

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subQuitter.getPosts()))")
    SubQuitterDto mapSubQuitterToDto(SubQuitter subQuitter);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    SubQuitter mapDtoToSubQuitter(SubQuitterDto subQuitterDto);
}
