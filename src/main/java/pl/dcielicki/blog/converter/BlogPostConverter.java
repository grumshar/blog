package pl.dcielicki.blog.converter;

import org.springframework.stereotype.Component;
import pl.dcielicki.blog.dto.BlogPostDto;
import pl.dcielicki.blog.model.BlogPost;

@Component
public class BlogPostConverter {
    
    public BlogPostDto convertToDto(BlogPost blogPost){
        BlogPostDto blogPostDto = new BlogPostDto();
        blogPostDto.setId(blogPost.getId());
        blogPostDto.setAuthor(blogPost.getAuthor());
        blogPostDto.setCommentsList(blogPost.getCommentsList());
        blogPostDto.setCreationTime(blogPost.getCreationTime());
        blogPostDto.setPostText(blogPost.getPostText());
        blogPostDto.setTitle(blogPost.getTitle());
        return blogPostDto;
    }

    public BlogPost convertToEntity(BlogPostDto blogPostDto){
        BlogPost blogPost = new BlogPost();
        blogPost.setId(blogPostDto.getId());
        blogPost.setAuthor(blogPostDto.getAuthor());
        blogPost.setCommentsList(blogPostDto.getCommentsList());
        blogPost.setCreationTime(blogPostDto.getCreationTime());
        blogPost.setPostText(blogPostDto.getPostText());
        blogPost.setTitle(blogPostDto.getTitle());
        return blogPost;
    }

}
