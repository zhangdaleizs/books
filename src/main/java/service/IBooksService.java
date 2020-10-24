package service;

import pojo.domain.BooksDO;
import util.Result;

import java.util.List;


public interface IBooksService
{
    Result addBooks(BooksDO booksDO);

    Result deleteBooks(Long id);

    Result updateBooksById(BooksDO booksDO);

    BooksDO selectBooksById(Long id);

    List<BooksDO> listBooksByName(String name);

    List<BooksDO> listBooksByAuthor(String author);

    List<BooksDO> listBooksByPublisher(String publisher);

    List<BooksDO> listBooksByIsbn(String isbn);

    List<BooksDO> listBooks();
}
