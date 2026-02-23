package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDateTime;
import java.util.List;

public class PostService {

    private EntityManager em;

    public PostService(EntityManager em) {
        this.em = em;
    }

    // Create Post
    public Post createPost(User author, String title, String content) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Post post = new Post();
        post.setAuthor(author);
        post.setTitle(title);
        post.setContent(content);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());

        em.persist(post);

        tx.commit();
        return post;
    }

    // Update
    public Post updatePost(Long id, String updatedContent) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Post post = em.find(Post.class, id);
        post.setContent(updatedContent);
        post.setUpdatedAt(LocalDateTime.now());

        tx.commit();
        return post;
    }

    // Delete
    public void deletePost(Long id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Post p = em.find(Post.class, id);
        em.remove(p);
        tx.commit();
    }

    // Fetch all posts by a user
    public List<Post> getPostsByUser(Long userId) {
        return em.createQuery(
                "SELECT p FROM Post p WHERE p.author.id = :uid", Post.class)
                .setParameter("uid", userId)
                .getResultList();
    }
}