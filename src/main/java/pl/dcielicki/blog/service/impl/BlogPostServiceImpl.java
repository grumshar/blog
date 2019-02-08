package pl.dcielicki.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dcielicki.blog.model.BlogPost;
import pl.dcielicki.blog.repository.BlogPostRepository;
import pl.dcielicki.blog.service.BlogPostService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    private BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public void save(BlogPost blogPost) {
        blogPostRepository.save(blogPost);
    }

    @Override
    public BlogPost getBlogPostById(Long id) {
        Optional<BlogPost> blogPost =  blogPostRepository.findById(id);
        if(!blogPost.isPresent()){
            throw new RuntimeException();
        }
        return blogPost.get();
    }

    @Override
    public List<BlogPost> getAllPosts() {
        List<BlogPost> list = new ArrayList<>();
        blogPostRepository.findAll().forEach(post -> list.add(post));
        return list;
    }

    @Override
    public void delete(BlogPost blogPost) {
        blogPostRepository.delete(blogPost);
    }
}
