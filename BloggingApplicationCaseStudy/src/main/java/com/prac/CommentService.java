package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDateTime;
import java.util.List;

public class CommentService {

    private EntityManager em;

    public CommentService(EntityManager em) {
        this.em = em;
    }

    // Add comment to a post
    public Comment addComment(User author, Post post, String content) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Comment c = new Comment();
        c.setAuthor(author);
        c.setPost(post);
        c.setContent(content);
        c.setCreatedAt(LocalDateTime.now());

        em.persist(c);
        tx.commit();
        return c;
    }

    // Get comments of a post
    public List<Comment> getCommentsByPost(Long postId) {
        return em.createQuery(
                "SELECT c FROM Comment c WHERE c.post.id = :pid", Comment.class)
                .setParameter("pid", postId)
                .getResultList();
    }

    // Get comments by a user
    public List<Comment> getCommentsByUser(Long userId) {
        return em.createQuery(
                "SELECT c FROM Comment c WHERE c.author.id = :uid", Comment.class)
                .setParameter("uid", userId)
                .getResultList();
    }
}