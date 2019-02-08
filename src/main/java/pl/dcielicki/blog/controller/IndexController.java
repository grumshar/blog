package pl.dcielicki.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.dcielicki.blog.converter.BlogPostConverter;
import pl.dcielicki.blog.dto.BlogPostDto;
import pl.dcielicki.blog.model.BlogPost;
import pl.dcielicki.blog.service.BlogPostService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private BlogPostService blogPostService;
    private BlogPostConverter blogPostConverter;

    @Autowired
    public IndexController(BlogPostService blogPostService, BlogPostConverter blogPostConverter) {
        this.blogPostService = blogPostService;
        this.blogPostConverter = blogPostConverter;
    }

    @GetMapping({"", "/", "/index"})
    public String showIndex(Model model){
        List<BlogPost> blogPosts = blogPostService.getAllPosts();
        List<BlogPostDto> blogPostDtos = new ArrayList<>();
        blogPosts.forEach(blogPost -> blogPostDtos.add(blogPostConverter.convertToDto(blogPost)));
        model.addAttribute("blogPosts", blogPostDtos);
        return "index";
    }

}
