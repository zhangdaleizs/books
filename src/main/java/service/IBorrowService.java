package service;

import pojo.domain.BorrowDO;
import util.Result;

import java.util.List;

public interface IBorrowService
{
    Result addBorrow(BorrowDO BorrowDO);

    Result deleteBorrow(Long id);

    Result updateBorrowById(BorrowDO BorrowDO);

    BorrowDO selectBorrowById(Long id);

    Result selectBorrowStatusByBooksId(Long id);

    Result selectBorrowStatusByUserId(Long id);

    List<BorrowDO> listBooksByBooks(Long id);

    List<BorrowDO> listBooksByUserId(Long id);

    Result returnBorrow(BorrowDO borrowDO);

    List<BorrowDO> listBooks();

    List<BorrowDO> listBooksByReturn();

    List<BorrowDO> listBooksByBorrow();
}
