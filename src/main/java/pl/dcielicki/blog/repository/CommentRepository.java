package pl.dcielicki.blog.repository;

import org.springframework.data.repository.CrudRepository;
import pl.dcielicki.blog.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
