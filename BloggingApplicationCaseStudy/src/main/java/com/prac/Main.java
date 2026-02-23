package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();

        UserService userService = new UserService(em);
        PostService postService = new PostService(em);
        CommentService commentService = new CommentService(em);

        // 1. Register user
        User u = new User();
        u.setName("Yash");
        u.setEmail("yash@mail.com");
        u.setPassword("12345");
        userService.registerUser(u);

        // 2. Create post
        Post p = postService.createPost(u, "My First Post", "This is my first blog post!");

        // 3. Add comment
        commentService.addComment(u, p, "Nice post!");

        // 4. Fetch posts by user
        System.out.println("Posts by Yash:");
        postService.getPostsByUser(u.getId()).forEach(po -> System.out.println(po.getTitle()));

        // 5. Fetch comments on post
        System.out.println("Comments on post:");
        commentService.getCommentsByPost(p.getId()).forEach(c -> System.out.println(c.getContent()));

        // 6. Fetch comments by user
        System.out.println("Comments by Yash:");
        commentService.getCommentsByUser(u.getId()).forEach(c -> System.out.println(c.getContent()));

        em.close();
        emf.close();
    }
}