package SpringData.AdvancedQueryingEx;

import SpringData.AdvancedQueryingEx.service.AuthorService;
import SpringData.AdvancedQueryingEx.service.BookService;
import SpringData.AdvancedQueryingEx.service.CategoryService;
import SpringData.AdvancedQueryingEx.model.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService,
                                 BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        //Ex.1
//        String restrictionInput = scanner.nextLine().toUpperCase();
//        printBookTitlesByByAgeRestriction(restrictionInput);

        //Ex.2
//        printGoldenEditionBooks();

        //Ex.3
//        printBooksByPrice();

        //Ex.4
//        int year = Integer.parseInt(scanner.nextLine());
//        printBooksByYear(year);

        //Ex.5
//        String date = scanner.nextLine();
//        printBooksBeforeReleaseDate(date);

        //Ex.6
//        String pattern = scanner.nextLine();
//        printAuthorsByEndingOfFirstName(pattern);

        //Ex.7
//        String substr = scanner.nextLine();
//        printBooksContainingSubstring(substr);

        //Ex.8
//        String start = scanner.nextLine();
//        printBooksByAuthorLastNameStartsWith(start);

        //Ex.9
//        String number = scanner.nextLine();
//        printCountOfBooksBySizeOfTheirNames(number);

        //Ex.10
        printTotalBookCopiesByAuthor();

//        seedData();
//
//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
    }

    private void printTotalBookCopiesByAuthor() {
        authorService.countTotalBookCopiesByAuthor()
                .forEach(System.out::println);
    }

    private void printCountOfBooksBySizeOfTheirNames(String number) {
        System.out.println(bookService.countBooksWithTitleLongerThan(number));
    }

    private void printBooksByAuthorLastNameStartsWith(String start) {
        bookService.selectBooksByAuthorLastName(start)
                .forEach(System.out::println);
    }

    private void printBooksContainingSubstring(String substr) {
        bookService.selectBooksBySubstringInTitle(substr)
                .forEach(System.out::println);
    }

    private void printAuthorsByEndingOfFirstName(String pattern) {
        authorService.selectAuthorsByEndingOfFirstName(pattern)
                .forEach(System.out::println);
    }

    private void printBooksBeforeReleaseDate(String date) {
        bookService.selectByReleaseDateBefore(date)
                .forEach(System.out::println);
    }

    private void printBooksByYear(int year) {
        bookService.selectBooksByYear(year)
                .forEach(System.out::println);
    }

    private void printBooksByPrice() {
        bookService.selectBooksByPrice()
                .forEach(System.out::println);
    }

    private void printGoldenEditionBooks() {
        bookService.selectGoldenEditionBooks()
                .forEach(System.out::println);
    }

    private void printBookTitlesByByAgeRestriction(String restrictionInput) {
        bookService.selectNamesByAgeRestriction(restrictionInput)
                .forEach(System.out::println);
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
