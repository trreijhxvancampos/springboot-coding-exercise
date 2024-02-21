package twist.resources.codingexercise.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import twist.resources.codingexercise.entity.AuthorEntity;
import twist.resources.codingexercise.entity.BookEntity;
import twist.resources.codingexercise.model.Author;
import twist.resources.codingexercise.model.Book;
import twist.resources.codingexercise.repository.BookRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    @Test
    void getBooks_ShouldReturn_AllBooks() {

        when(bookRepository.findAll()).thenReturn(List.of(BookEntity.builder()
                .id(1)
                .name("Adventures of John Doe")
                .author(AuthorEntity.builder()
                        .id(1)
                        .name("John Doe")
                        .build())
                .build()
        ));
        assertThat(bookService.getBooks())
                .contains(Book.builder()
                        .id(1)
                        .name("Adventures of John Doe")
                        .author(Author.builder()
                                .id(1)
                                .name("John Doe")
                                .build())
                        .build()
                );


    }

    @Test
    void getBooksByName_ShouldReturn_AllBooksWithSpecifiedName(){
        assertThat(bookService.getBooksByName("Adventures of John Doe"))
                .contains(Book.builder()
                        .id(1)
                        .name("Adventures of John Doe")
                        .author(Author.builder()
                                .id(1)
                                .name("John Doe")
                                .build())
                        .build());
    }
}
