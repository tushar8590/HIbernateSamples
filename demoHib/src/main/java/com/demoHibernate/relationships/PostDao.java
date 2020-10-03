package com.demoHibernate.relationships;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PostDao {

	@PersistenceContext
	EntityManager entityManager;
	@Transactional
	public Post addPostAndComment(String title) {
		   Post p1 = new Post(); p1.setTitle(title); 
		   p1 =  entityManager.merge(p1);
	       PostComment pc1 = new PostComment();
	       pc1.setReview(title + "c1");
	       p1.addComment(pc1);
	       PostComment pc2 = new PostComment();
	       pc2.setReview(title + "c2");
	       p1.addComment(pc2);
	       entityManager.flush();
	       return p1;
	}
	
	@Transactional
	public Post removeComment(Post post, PostComment pcc) {
		post.removeComment(pcc);
		post = entityManager.merge(post);
		return post;
	}
	
}
