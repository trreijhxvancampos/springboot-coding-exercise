package twist.resources.codingexercise.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import twist.resources.codingexercise.entity.AuthorEntity;
import twist.resources.codingexercise.entity.BookEntity;
import twist.resources.codingexercise.model.Author;
import twist.resources.codingexercise.model.Book;
import twist.resources.codingexercise.repository.AuthorRepository;
import twist.resources.codingexercise.repository.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

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

    public List<Book> getBooksByName(String name) {
        return bookRepository.findByName(name).stream()
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

    public void save(BookEntity book) {
//        AuthorEntity authorEntity = authorRepository.findById(book);

//        BookEntity bookEntity = BookEntity.builder()
//                .id(bookId)
//                .name(name)
//                .author(authorEntity)
//                .build();

        bookRepository.save(book);
    }

    public void deleteById(Integer bookId) {
        bookRepository.deleteById(bookId);

    }

    public Optional<BookEntity> findById(Integer bookId) {
        return bookRepository.findById(bookId);
    }
}
