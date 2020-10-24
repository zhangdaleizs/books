package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import pojo.domain.BorrowDO;

public interface BorrowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BorrowDO record);

    BorrowDO selectByPrimaryKey(Long id);

    List<BorrowDO> selectAll();

    int updateByPrimaryKey(BorrowDO record);

    List<BorrowDO> selectBorrowStatusByBooksId(Long id);

    List<BorrowDO> selectBorrowStatusByUserId(Long id);

    List<BorrowDO> listBooksByStatus(int status);
}