package twist.resources.codingexercise.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import twist.resources.codingexercise.model.Author;
import twist.resources.codingexercise.model.Book;
import twist.resources.codingexercise.service.BookService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookControllerTest {

    @Autowired
    // inject dependency
    BookController bookController;

    // method, input, output
    @Test
    void getBooks_ExistingBooks_ReturnListOfBooks(){
        assertThat(bookController.getBooks())
                .contains(Book.builder()
                        .id(1)
                        .name("Adventures of John Doe")
                        .author(Author.builder()
                                .id(1)
                                .name("John Doe")
                                .build())
                        .build());
    }

    @Test
    void getBooks_ByName_ReturnBooksWithSpecifiedName(){
        assertThat(bookController.getBooksByName("Adventures of John Doe"))
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