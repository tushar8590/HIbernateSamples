package com.demoHibernate.relationships;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Post")
public class Post {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String title;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true,mappedBy = "post")
	private List<PostComment> postComments = new ArrayList<>();

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void addComment(PostComment pc) {
		this.postComments.add(pc);
		pc.setPost(this);
	}
	
	public void removeComment(PostComment pc) {
		this.postComments.remove(pc);
		pc.setPost(null);
	}

	public List<PostComment> getPostComments() {
		return postComments;
	}
}
