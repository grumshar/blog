package pl.dcielicki.blog.repository;

import org.springframework.data.repository.CrudRepository;
import pl.dcielicki.blog.model.BlogPost;

public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {

}
