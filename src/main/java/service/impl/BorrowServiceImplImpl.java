package service.impl;

import dao.BorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.domain.BooksDO;
import pojo.domain.BorrowDO;
import service.IBooksService;
import service.IBorrowService;
import util.Result;

import java.util.List;

@Service
public class BorrowServiceImplImpl implements IBorrowService
{
    @Autowired
    private BorrowMapper mapper;
    @Autowired
    private IBooksService booksService;

    @Override
    @Transactional
    public Result addBorrow(BorrowDO borrowDO)
    {
        //借阅书籍,检查书籍是否还有剩余数量
        BooksDO booksDO = booksService.selectBooksById(borrowDO.getUserId());
        if(booksDO == null)
        {
            return Result.fail("借阅的书籍不存在!");
        }
        if(booksDO.getAmount()>0)
        {
            booksDO.setAmount(booksDO.getAmount()-1);
            booksService.updateBooksById(booksDO);
        }else
            {
                return Result.fail("该书籍已全部被借空!");
            }
        borrowDO.setStatus(0);
        if(mapper.insert(borrowDO)>0)
        {
            return Result.ok();
        }
        return Result.fail();
    }

    @Override
    public Result deleteBorrow(Long id)
    {
        if(mapper.deleteByPrimaryKey(id)>0)
        {
            return Result.ok();
        }
        return Result.fail();
    }

    @Override
    public Result updateBorrowById(BorrowDO borrowDO)
    {
        if(mapper.updateByPrimaryKey(borrowDO)>0)
        {
            return Result.ok();
        }
        return Result.fail();
    }

    @Override
    public BorrowDO selectBorrowById(Long id)
    {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Result selectBorrowStatusByBooksId(Long id)
    {
        List<BorrowDO> list = mapper.selectBorrowStatusByBooksId(id);
        if(list !=null && list.size()>0)
        {
            return Result.ok(list);
        }
        return Result.fail();
    }

    @Override
    public Result selectBorrowStatusByUserId(Long id)
    {
        List<BorrowDO> list = mapper.selectBorrowStatusByUserId(id);
        if(list !=null && list.size()>0)
        {
            return Result.ok(list);
        }
        return Result.fail();
    }

    @Override
    public List<BorrowDO> listBooksByBooks(Long id)
    {
        return mapper.selectBorrowStatusByBooksId(id);
    }

    @Override
    public List<BorrowDO> listBooksByUserId(Long id) {
        return mapper.selectBorrowStatusByUserId(id);
    }

    @Transactional
    public Result returnBorrow(BorrowDO borrowDO)
    {

        borrowDO.setStatus(1);
        if(mapper.updateByPrimaryKey(borrowDO)>0)
        {
            //借阅书籍,检查书籍是否还有剩余数量
            BooksDO booksDO = booksService.selectBooksById(borrowDO.getUserId());
            if(booksDO == null)
            {
                throw new RuntimeException("借阅的书籍不存在");
            }
            //书籍库存+1
            booksDO.setAmount(booksDO.getAmount()+1);
            if(booksService.updateBooksById(booksDO).getCode().equals(0))
            {
                return Result.ok();
            }
            throw new RuntimeException("更换书籍信息失败");
        }
        return Result.fail();
    }

    @Override
    public List<BorrowDO> listBooks()
    {
        return mapper.selectAll();
    }

    @Override
    public List<BorrowDO> listBooksByReturn()
    {
        return mapper.listBooksByStatus(1);
    }

    @Override
    public List<BorrowDO> listBooksByBorrow() {
        return mapper.listBooksByStatus(0);
    }
}
