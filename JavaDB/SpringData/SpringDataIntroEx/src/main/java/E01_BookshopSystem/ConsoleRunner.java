package E01_BookshopSystem;

import E01_BookshopSystem.entities.Author;
import E01_BookshopSystem.entities.Book;
import E01_BookshopSystem.repositories.AuthorRepository;
import E01_BookshopSystem.repositories.BookRepository;
import E01_BookshopSystem.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.seedService = seedService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedService.seedAll();
        this.booksAfter2000();
        this.authorsWhoWroteBefore1990();
    }

    private void authorsWhoWroteBefore1990() {
        LocalDate year1990 = LocalDate.of(1990, 1, 1);
        List<Author> authors = this.authorRepository.findDistinctByBooksReleaseDateBefore(year1990);

        authors.stream()
                .map(a -> String.format("%s %s", a.getFirstName(), a.getLastName()))
                .forEach(System.out::println);
    }

    private void booksAfter2000() {
        LocalDate year2000 = LocalDate.of(2000, 12, 31);
        List<Book> books = this.bookRepository.findByReleaseDateAfter(year2000);

        books.stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }
}
