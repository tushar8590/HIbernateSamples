package com.demoHibernate.relationships;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demoHibernate.demoHib.ExampleRunner;

@Component("relationRunner")
@Transactional
public class RelationshipRunner implements ExampleRunner{

	@Autowired
	private PostDao  postDao ;
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public void run(ApplicationContext ctx) {
		/*
		 * Post p1 = postDao.addPostAndComment("My New Post"); PostComment pcc =
		 * p1.getPostComments().get(0); postDao.removeComment(p1, pcc);
		 */
		PostComment pc = em.find(PostComment.class, 89L);
		System.out.println(pc.getReview());
		
	}
	
	

}
