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
import java.util.Map;
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

    public void createBook(Map<String, Object> book) {
        String bookName = (String) book.get("name");
        Integer authorId = (Integer) book.get("author_id");

        Optional<AuthorEntity> author = authorRepository.findById(authorId);
        if (author.isPresent()){
            BookEntity newBook = BookEntity.builder()
                    .name(bookName)
                    .author(AuthorEntity.builder()
                            .id(author.get().getId())
                            .name(author.get().getName())
                            .build())
                    .build();

            bookRepository.save(newBook);
        }

    }
    public void updateBook(Integer bookId, Map<String, Object> bookDetails) {
        String bookName = (String) bookDetails.get("name");
        Integer authorId = (Integer) bookDetails.get("author_id");

        Optional<AuthorEntity> author = authorRepository.findById(authorId);
        Optional<BookEntity> oldBook = bookRepository.findById(bookId);
        if (oldBook.isPresent() && author.isPresent()){
            BookEntity updatedBook = oldBook.get();
            updatedBook.setName(bookName);
            updatedBook.setAuthor(AuthorEntity.builder()
                    .id(author.get().getId())
                    .name(author.get().getName())
                    .build());

            bookRepository.save(updatedBook);
        }

    }
    public void deleteById(Integer bookId) {
        bookRepository.deleteById(bookId);

    }



}
