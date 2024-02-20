package twist.resources.codingexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import twist.resources.codingexercise.entity.BookEntity;
import twist.resources.codingexercise.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer>{
    List<BookEntity> findAll();

}
