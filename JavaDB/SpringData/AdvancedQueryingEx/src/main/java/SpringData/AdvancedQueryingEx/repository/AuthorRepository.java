package SpringData.AdvancedQueryingEx.repository;

import SpringData.AdvancedQueryingEx.model.entity.Author;
import SpringData.AdvancedQueryingEx.model.entity.AuthorNamesWithTotalCopies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    List<Author> findAllByBooksSizeDESC();

    List<Author> findByFirstNameEndingWith(String pattern);

    @Query("SELECT a.firstName AS firstName, a.lastName AS lastName, SUM(b.copies) AS totalCopies " +
            " FROM Author a" +
            " JOIN a.books as b" +
            " GROUP BY b.author" +
            " ORDER BY totalCopies DESC")
    List<AuthorNamesWithTotalCopies> selectCopiesCountGroupByAuthor();
}
