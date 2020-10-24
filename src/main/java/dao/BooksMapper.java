package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import pojo.domain.BooksDO;

public interface BooksMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BooksDO record);

    BooksDO selectByPrimaryKey(Long id);

    List<BooksDO> selectAll();

    int updateByPrimaryKey(BooksDO record);

    List<BooksDO> listBooksByName(String name);

    List<BooksDO> listBooksByAuthor(String author);

    List<BooksDO> listBooksByPublisher(String publisher);

    List<BooksDO> listBooksByIsbn(String isbn);
}