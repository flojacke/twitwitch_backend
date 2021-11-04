package com.frey.quitter.dto;

import java.util.Objects;

import lombok.Builder;


@Builder
public class SubQuitterDto {
    private Long id;
    private String name;
    private String description;
    private Integer numberOfPosts;
    
    public SubQuitterDto() {
    	
    }
    
	public SubQuitterDto(Long id, String name, String description, Integer numberOfPosts) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.numberOfPosts = numberOfPosts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNumberOfPosts() {
		return numberOfPosts;
	}

	public void setNumberOfPosts(Integer numberOfPosts) {
		this.numberOfPosts = numberOfPosts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, name, numberOfPosts);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubQuitterDto other = (SubQuitterDto) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(numberOfPosts, other.numberOfPosts);
	}

	@Override
	public String toString() {
		return "SubQuitterDto [id=" + id + ", name=" + name + ", description=" + description + ", numberOfPosts="
				+ numberOfPosts + "]";
	}
    
    
}
