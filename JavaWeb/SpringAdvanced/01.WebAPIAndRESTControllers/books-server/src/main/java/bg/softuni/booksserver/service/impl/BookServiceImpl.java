package bg.softuni.booksserver.service.impl;

import bg.softuni.booksserver.model.dto.AuthorDTO;
import bg.softuni.booksserver.model.dto.BookDTO;
import bg.softuni.booksserver.model.entity.Author;
import bg.softuni.booksserver.model.entity.Book;
import bg.softuni.booksserver.repository.AuthorRepository;
import bg.softuni.booksserver.repository.BookRepository;
import bg.softuni.booksserver.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(BookServiceImpl::mapBookDTO)
                .toList();
    }

    @Override
    public Optional<BookDTO> findBookById(Long id) {
        return bookRepository.findById(id)
                .map(BookServiceImpl::mapBookDTO);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Long createBook(BookDTO bookDTO) {
        Author author = authorRepository.findByName(bookDTO.getAuthor().getName()).orElse(null);

        if(author == null) {
            author = new Author()
                    .setName(bookDTO.getAuthor().getName());
            author = authorRepository.save(author);
        }

        Book newBook = new Book()
                .setAuthor(author)
                .setTitle(bookDTO.getTitle())
                .setIsbn(bookDTO.getIsbn());

        newBook = bookRepository.save(newBook);

        return newBook.getId();
    }

    private static BookDTO mapBookDTO(Book book) {
        AuthorDTO author = new AuthorDTO().setName(book.getAuthor().getName());

        return new BookDTO()
                .setId(book.getId())
                .setAuthor(author)
                .setTitle(book.getTitle())
                .setIsbn(book.getIsbn());
    }
}
