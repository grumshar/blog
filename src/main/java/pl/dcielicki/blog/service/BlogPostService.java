package pl.dcielicki.blog.service;

import pl.dcielicki.blog.model.BlogPost;

import java.util.List;

public interface BlogPostService {

    void save(BlogPost blogPost);
    BlogPost getBlogPostById(Long id);
    List<BlogPost> getAllPosts();
    void delete(BlogPost blogPost);
    void setPostCreationTime(BlogPost blogPost);
    void setPostAuthor(BlogPost blogPost);

}
