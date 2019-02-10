package pl.dcielicki.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dcielicki.blog.model.BlogPost;
import pl.dcielicki.blog.model.User;
import pl.dcielicki.blog.repository.BlogPostRepository;
import pl.dcielicki.blog.service.BlogPostService;

import java.time.LocalDateTime;
import java.util.*;

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
        list.sort(Comparator.comparing(BlogPost::getCreationTime).reversed());
        return list;
    }

    @Override
    public void delete(BlogPost blogPost) {
        blogPostRepository.delete(blogPost);
    }

    @Override
    public void deletePostById(Long id){
        blogPostRepository.deleteById(id);
    }

    @Override
    public void setPostCreationTime(BlogPost blogPost){
        if(!isInDatabase(blogPost)){
            blogPost.setCreationTime(LocalDateTime.now());
        }
    }

    @Override
    public void setPostAuthor(BlogPost blogPost){
        if(!isInDatabase(blogPost)){
            blogPost.setAuthor(new User());
        }
    }

    private boolean isInDatabase(BlogPost blogPost){
        return blogPost.getId() != null;
    }

}
