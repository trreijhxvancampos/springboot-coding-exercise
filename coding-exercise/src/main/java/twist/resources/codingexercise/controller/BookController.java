package twist.resources.codingexercise.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import twist.resources.codingexercise.entity.BookEntity;
import twist.resources.codingexercise.model.Book;
import twist.resources.codingexercise.service.BookService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;

    //    @GetMapping("/books")
    @GetMapping("/booksNotAnymore")
    public List<Book> getBooks() {
        return bookService.getBooks();

    }

    @GetMapping(value = "/books/{name}")
    public List<Book> getBooksByName(@PathVariable String name) {
        return bookService.getBooksByName(name);
    }


    @PostMapping(value = "/createBook")
    public void createBook(@RequestBody BookEntity book) {
        bookService.save(book);
    }

    @PostMapping(value="/updateBook/{bookId}")
    public void updateBook(@PathVariable Integer bookId, @RequestBody Book book){
    }
    @DeleteMapping(value = "/deleteBook/{bookId}")
    public void deleteBookById(@PathVariable Integer bookId) {
        bookService.deleteById(bookId);
    }

    public Optional<BookEntity> findBookById(Integer bookId) {
        return bookService.findById(bookId);
    }
}
