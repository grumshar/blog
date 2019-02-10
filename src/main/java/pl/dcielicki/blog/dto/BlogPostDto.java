package pl.dcielicki.blog.dto;

import pl.dcielicki.blog.model.Comment;
import pl.dcielicki.blog.model.User;

import java.time.LocalDateTime;
import java.util.List;

public class BlogPostDto {

    private Long id;
    private String title;
    private LocalDateTime creationTime;
    private String postText;
    private User author;
    private List<Comment> commentsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    @Override
    public String toString() {
        return "BlogPostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", creationTime=" + creationTime +
                ", postText='" + postText + '\'' +
                ", author=" + author +
                ", commentsList=" + commentsList +
                '}';
    }
}
