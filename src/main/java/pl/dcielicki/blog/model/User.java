package pl.dcielicki.blog.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    @OneToMany(mappedBy = "author")
    private List<BlogPost> blogPostsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BlogPost> getBlogPostsList() {
        return blogPostsList;
    }

    public void setBlogPostsList(List<BlogPost> blogPostsList) {
        this.blogPostsList = blogPostsList;
    }

}
