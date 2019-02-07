package pl.dcielicki.blog.service;

import pl.dcielicki.blog.model.BlogPost;

public interface BlogPostService {

    void save(BlogPost blogPost);
    BlogPost getBlogPostById(Long id);

}
