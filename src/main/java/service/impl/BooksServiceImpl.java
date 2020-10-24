package service.impl;

import dao.BooksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.domain.BooksDO;
import service.IBooksService;
import service.IBorrowService;
import util.Result;

import java.util.List;

@Service
public class BooksServiceImpl implements IBooksService
{
    @Autowired
    private BooksMapper mapper;
    @Autowired
    private IBorrowService borrowService;

    @Override
    public Result addBooks(BooksDO booksDO)
    {
        if(mapper.insert(booksDO)>0)
        {
            return Result.ok();
        }
        return Result.fail();
    }

    @Override
    public Result deleteBooks(Long id)
    {
        if(borrowService.selectBorrowStatusByBooksId(id).getCode().equals(0))
        {
            return Result.fail("该书籍已借出,无法删除书籍");
        }
        if(mapper.deleteByPrimaryKey(id)>0)
        {
            return Result.ok();
        }
        return Result.fail();
    }

    @Override
    public Result updateBooksById(BooksDO booksDO)
    {
        //检查是否存在借阅信息
        if(borrowService.selectBorrowStatusByBooksId(booksDO.getId()).getCode().equals(0))
        {
            return Result.fail("该书籍已借出,无法修改信息");
        }
        if(mapper.updateByPrimaryKey(booksDO)>0)
        {
            return Result.ok();
        }
        return Result.fail();
    }

    @Override
    public BooksDO selectBooksById(Long id)
    {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BooksDO> listBooksByName(String name)
    {
        return mapper.listBooksByName(name);
    }

    @Override
    public List<BooksDO> listBooksByAuthor(String author) {
        return mapper.listBooksByAuthor(author);
    }

    @Override
    public List<BooksDO> listBooksByPublisher(String publisher) {
        return mapper.listBooksByPublisher(publisher);
    }

    @Override
    public List<BooksDO> listBooksByIsbn(String isbn) {
        return mapper.listBooksByIsbn(isbn);
    }

    @Override
    public List<BooksDO> listBooks()
    {
        return mapper.selectAll();
    }

}
