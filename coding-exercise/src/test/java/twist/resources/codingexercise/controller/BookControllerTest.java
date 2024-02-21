package twist.resources.codingexercise.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import twist.resources.codingexercise.model.Author;
import twist.resources.codingexercise.model.Book;
import twist.resources.codingexercise.service.BookService;

import java.util.List;

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
    void getBooks_BookName_ReturnBooksWithSpecifiedName(){
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

//    @Test
//    void createBook_BookProperties_CreatedBook(){
//        String bookName = "SampleBook";
//        Integer authorId = 1;
//        bookController.createBook(bookName, authorId);
//
//        List<Book> books = bookController.getBooksByName(bookName);
//        assertThat(books).isNotEmpty();
//
//        Book createdBook = books.get(0);
//        assertThat(createdBook.getName()).isEqualTo(bookName);
//        assertThat(createdBook.getAuthor().getId()).isEqualTo(authorId);
//    }

//    @Test
//    void deleteBook_BookId_DeletedBook(){
//        Integer bookId = 69;
//        String bookName = "SampleBook";
//        Integer authorId = 1;
//
//        bookController.createBook(bookId, bookName, authorId);
//        bookController.deleteBookById(bookId);
//        assertThat(bookController.findBookById(bookId)).isNull();
//    }

}