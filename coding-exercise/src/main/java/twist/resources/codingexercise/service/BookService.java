package twist.resources.codingexercise.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import twist.resources.codingexercise.model.Author;
import twist.resources.codingexercise.model.Book;
import twist.resources.codingexercise.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll().stream()
                .map(bookEntity -> Book.builder()
                        .id(bookEntity.getId())
                        .name(bookEntity.getName())
                        .author(Author.builder()
                                .id(bookEntity.getAuthor().getId())
                                .name(bookEntity.getAuthor().getName())
                                .build())
                        .build()
                )
                .collect(Collectors.toList());
    }

}
