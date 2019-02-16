package pl.dcielicki.blog.converter;

import org.springframework.stereotype.Component;
import pl.dcielicki.blog.dto.CommentDto;
import pl.dcielicki.blog.model.Comment;

@Component
public class CommentConverter {

    public CommentDto convertToDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setAuthor(comment.getAuthor());
        commentDto.setBlogPost(comment.getBlogPost());
        commentDto.setCommentText(comment.getCommentText());
        commentDto.setCreationTime(comment.getCreationTime());
        return commentDto;
    }

    public Comment convertToEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setAuthor(commentDto.getAuthor());
        comment.setBlogPost(commentDto.getBlogPost());
        comment.setCommentText(commentDto.getCommentText());
        comment.setCreationTime(commentDto.getCreationTime());
        return comment;
    }
}
