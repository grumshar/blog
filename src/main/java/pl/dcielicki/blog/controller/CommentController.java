package pl.dcielicki.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.dcielicki.blog.converter.CommentConverter;
import pl.dcielicki.blog.dto.CommentDto;
import pl.dcielicki.blog.model.Comment;
import pl.dcielicki.blog.service.BlogPostService;
import pl.dcielicki.blog.service.CommentService;

import java.time.LocalDateTime;

@Controller
public class CommentController {

    private CommentService commentService;
    private CommentConverter commentConverter;
    private BlogPostService blogPostService;

    @Autowired
    public CommentController(CommentService commentService, CommentConverter commentConverter, BlogPostService blogPostService) {
        this.commentService = commentService;
        this.commentConverter = commentConverter;
        this.blogPostService = blogPostService;
    }

    @PostMapping("/saveComment")
    public String saveComment(@ModelAttribute CommentDto commentDto, @RequestParam Long id){
        Comment commentToSave = commentConverter.convertToEntity(commentDto);
        commentToSave.setBlogPost(blogPostService.getBlogPostById(id));
        commentToSave.setCreationTime(LocalDateTime.now());
        commentService.save(commentToSave);
        return "redirect:/showBlogPost/" + id;
    }
}
