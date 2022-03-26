package SpringData.AdvancedQueryingEx.repository;

import SpringData.AdvancedQueryingEx.model.entity.AgeRestriction;
import SpringData.AdvancedQueryingEx.model.entity.Author;
import SpringData.AdvancedQueryingEx.model.entity.Book;
import SpringData.AdvancedQueryingEx.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findByAgeRestriction(AgeRestriction restriction);

    List<Book> findByEditionTypeAndCopiesLessThan(EditionType type, int copies);

    List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal higher);

    List<Book> findAllByReleaseDateLessThanOrReleaseDateGreaterThan(LocalDate before, LocalDate after);

    List<Book> findByTitleContaining(String substr);

    List<Book> findByAuthorLastNameStartingWith(String start);

    @Query("SELECT COUNT(b) FROM Book b WHERE length(b.title) > :size")
    int countByNameSize(int size);

    @Query("SELECT b.copies FROM Book b" +
            " GROUP BY b.author")
    List<Author> selectCopiesCountGroupByAuthor();
}
