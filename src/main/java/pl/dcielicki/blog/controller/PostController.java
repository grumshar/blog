package pl.dcielicki.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.dcielicki.blog.converter.BlogPostConverter;
import pl.dcielicki.blog.dto.BlogPostDto;
import pl.dcielicki.blog.model.BlogPost;
import pl.dcielicki.blog.model.User;
import pl.dcielicki.blog.service.BlogPostService;

import java.time.LocalDateTime;

@Controller
public class PostController {

    private BlogPostService blogPostService;
    private BlogPostConverter blogPostConverter;

    public PostController(BlogPostService blogPostService, BlogPostConverter blogPostConverter) {
        this.blogPostService = blogPostService;
        this.blogPostConverter = blogPostConverter;
    }

    @GetMapping("/addPost")
    public String addPost(Model model) {
        BlogPostDto blogPostDto = new BlogPostDto();
        model.addAttribute("blogPostToCreate", blogPostDto);
        return "addPost";
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute BlogPostDto blogPostDto){
        BlogPost blogPost = blogPostConverter.convertToEntity(blogPostDto);
        blogPost.setAuthor(new User());
        blogPost.setCreationTime(LocalDateTime.now());
        blogPostService.save(blogPost);
        return "redirect:/showPost/" + blogPost.getId();
    }

    @GetMapping("/showPost/{id}")
    public String showPost(@PathVariable Long id, Model model){
        BlogPost blogPost = blogPostService.getBlogPostById(id);
        BlogPostDto blogPostDto = blogPostConverter.convertToDto(blogPost);
        model.addAttribute("blogPost", blogPostDto);
        return "showPost";
    }

}
