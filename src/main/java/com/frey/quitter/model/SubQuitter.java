package com.frey.quitter.model;


import lombok.Builder;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Builder
public class SubQuitter {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotBlank(message = "Community name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;
    @OneToMany(fetch = LAZY)
    private List<Post> posts;
    private Instant createdDate;
    @ManyToOne(fetch = LAZY)
    private User user;
	
    public SubQuitter() {
    	
    }
    
	public SubQuitter(Long id, @NotBlank(message = "Community name is required") String name,
			@NotBlank(message = "Description is required") String description, List<Post> posts, Instant createdDate,
			User user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.posts = posts;
		this.createdDate = createdDate;
		this.user = user;
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




	public List<Post> getPosts() {
		return posts;
	}




	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}




	public Instant getCreatedDate() {
		return createdDate;
	}




	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}

	

	@Override
	public String toString() {
		return "SubQuitter [id=" + id + ", name=" + name + ", description=" + description + ", posts=" + posts
				+ ", createdDate=" + createdDate + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdDate, description, id, name, posts, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubQuitter other = (SubQuitter) obj;
		return Objects.equals(createdDate, other.createdDate) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(posts, other.posts) && Objects.equals(user, other.user);
	}



    
    
    
}
