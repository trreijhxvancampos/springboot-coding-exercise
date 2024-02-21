package twist.resources.codingexercise.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import twist.resources.codingexercise.entity.BookEntity;
import twist.resources.codingexercise.model.Book;
import twist.resources.codingexercise.service.BookService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;

    //    @GetMapping("/books")
    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();

    }

    @GetMapping(value = "/books/{name}")
    public List<Book> getBooksByName(@PathVariable String name) {
        return bookService.getBooksByName(name);
    }


    @PostMapping(value = "/createBook")
    public void createBook(@RequestBody Map<String, Object> book) {
        bookService.createBook(book);
    }

    @PutMapping(value="/updateBook/{bookId}")
    public void updateBook(@PathVariable Integer bookId, @RequestBody Map<String, Object> book){
        bookService.updateBook(bookId, book);

    }
    @DeleteMapping(value = "/deleteBook/{bookId}")
    public void deleteBookById(@PathVariable Integer bookId) {
        bookService.deleteById(bookId);
    }

}
