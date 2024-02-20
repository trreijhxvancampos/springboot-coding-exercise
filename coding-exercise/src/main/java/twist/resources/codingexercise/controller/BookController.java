package twist.resources.codingexercise.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import twist.resources.codingexercise.model.Book;
import twist.resources.codingexercise.service.BookService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;
    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();

    }

//    @GetMapping(value = "/books/{name}")
//    public Book getBookByName(@PathVariable String name) {
//        return bookService.getBookByName(name);
//    }
}
