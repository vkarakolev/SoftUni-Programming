package SpringData.AdvancedQueryingEx.service.impl;

import SpringData.AdvancedQueryingEx.model.entity.*;
import SpringData.AdvancedQueryingEx.repository.BookRepository;
import SpringData.AdvancedQueryingEx.service.AuthorService;
import SpringData.AdvancedQueryingEx.service.BookService;
import SpringData.AdvancedQueryingEx.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
       return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> selectNamesByAgeRestriction(String restriction) {
        return bookRepository.findByAgeRestriction(AgeRestriction.valueOf(restriction))
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> selectGoldenEditionBooks() {
        return bookRepository.findByEditionTypeAndCopiesLessThan(EditionType.valueOf("GOLD"), 5000)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> selectBooksByPrice() {
        return bookRepository.findByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .stream()
                .map(b -> String.format("%s - $%.2f", b.getTitle(), b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> selectBooksByYear(int year) {
        return bookRepository.findAllByReleaseDateLessThanOrReleaseDateGreaterThan(
                LocalDate.of(year, 01 ,01), LocalDate.of(year, 12, 31))
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> selectByReleaseDateBefore(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate before = LocalDate.parse(date, formatter);

        return bookRepository.findAllByReleaseDateBefore(before)
                .stream()
                .map(b -> String.format("%s %s %.2f",b.getTitle(), b.getEditionType().name(), b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> selectBooksBySubstringInTitle(String substr) {
        return bookRepository.findByTitleContaining(substr)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> selectBooksByAuthorLastName(String start) {
        return bookRepository.findByAuthorLastNameStartingWith(start)
                .stream()
                .map(b -> String.format("%s (%s %s)",
                        b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public int countBooksWithTitleLongerThan(String number) {
        int size = Integer.parseInt(number);
        return bookRepository.countByNameSize(size);
    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
