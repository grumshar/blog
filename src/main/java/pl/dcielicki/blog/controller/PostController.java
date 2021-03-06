package pl.dcielicki.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.dcielicki.blog.converter.BlogPostConverter;
import pl.dcielicki.blog.dto.BlogPostDto;
import pl.dcielicki.blog.dto.CommentDto;
import pl.dcielicki.blog.model.BlogPost;
import pl.dcielicki.blog.service.BlogPostService;

@Controller
public class PostController {

    private BlogPostService blogPostService;
    private BlogPostConverter blogPostConverter;

    public PostController(BlogPostService blogPostService, BlogPostConverter blogPostConverter) {
        this.blogPostService = blogPostService;
        this.blogPostConverter = blogPostConverter;
    }

    @GetMapping("/addBlogPost")
    public String addPost(Model model) {
        if(model.containsAttribute("blogPostToCreate")){
            return "blogPostForm";
        }
        BlogPostDto blogPostDto = new BlogPostDto();
        model.addAttribute("blogPostToCreate", blogPostDto);
        return "blogPostForm";
    }

    @PostMapping("/editBlogPost")
    public String editPost(@RequestParam Long id, RedirectAttributes redirectAttributes){
        BlogPost blogPost = blogPostService.getBlogPostById(id);
        BlogPostDto blogPostDto = blogPostConverter.convertToDto(blogPost);
        redirectAttributes.addFlashAttribute("blogPostToCreate", blogPostDto);
        return "redirect:/addBlogPost";
    }

    @PostMapping("/saveBlogPost")
    public String savePost(@ModelAttribute BlogPostDto blogPostDto){
        BlogPost blogPost = blogPostConverter.convertToEntity(blogPostDto);
        blogPostService.setPostAuthor(blogPost);
        blogPostService.setPostCreationTime(blogPost);
        blogPostService.save(blogPost);
        return "redirect:/showBlogPost/" + blogPost.getId();
    }

    @GetMapping("/showBlogPost/{id}")
    public String showPost(@PathVariable Long id, Model model){
        BlogPost blogPost = blogPostService.getBlogPostById(id);
        BlogPostDto blogPostDto = blogPostConverter.convertToDto(blogPost);
        CommentDto commentDto = new CommentDto();
        model.addAttribute("blogPost", blogPostDto);
        model.addAttribute("comment", commentDto);
        return "showBlogPost";
    }

    @PostMapping("/deleteBlogPost")
    public String deletePost(@RequestParam Long id){
        blogPostService.deletePostById(id);
        return "redirect:/index";
    }

}
