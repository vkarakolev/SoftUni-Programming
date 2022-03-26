package SpringData.AdvancedQueryingEx.service;

import SpringData.AdvancedQueryingEx.model.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();

    List<String> selectAuthorsByEndingOfFirstName(String pattern);

    List<String> countTotalBookCopiesByAuthor();
}
