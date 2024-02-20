package twist.resources.codingexercise.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import twist.resources.codingexercise.entity.AuthorEntity;
import twist.resources.codingexercise.entity.BookEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    void findAll_ShouldReturn_AllBooks(){
        assertThat(bookRepository.findAll())
                .containsExactlyInAnyOrder(BookEntity.builder()
                        .id(1)
                        .name("Adventures of John Doe")
                        .author(AuthorEntity.builder()
                                .id(1)
                                .name("John Doe")
                                .build())
                        .build()
                );
    }
}
