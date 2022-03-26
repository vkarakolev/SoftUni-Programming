package SpringData.AdvancedQueryingEx.service;

import SpringData.AdvancedQueryingEx.model.entity.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> selectNamesByAgeRestriction(String restriction);

    List<String> selectGoldenEditionBooks();

    List<String> selectBooksByPrice();

    List<String> selectBooksByYear(int year);

    List<String> selectByReleaseDateBefore(String date);

    List<String> selectBooksBySubstringInTitle(String substr);

    List<String> selectBooksByAuthorLastName(String start);

    int countBooksWithTitleLongerThan(String number);
}
