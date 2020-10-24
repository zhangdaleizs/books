package service.impl;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.domain.UserDO;
import service.IBorrowService;
import service.IUserService;
import util.Result;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserMapper mapper;
    @Autowired
    private IBorrowService borrowService;

    public Result addUser(UserDO userDO)
    {
        if(mapper.insert(userDO)>0)
        {
            return Result.ok();
        }
        return Result.fail();
    }

    @Override
    public Result deleteUser(Long id)
    {
        //用户是否已经借阅书籍,如已借阅,无法删除
        if(borrowService.selectBorrowStatusByUserId(id).getCode().equals(0))
        {
            return Result.fail("该用户已借阅书籍,无法删除");
        }
        if(mapper.deleteByPrimaryKey(id)>0)
        {
            return Result.ok();
        }
        return Result.fail();
    }

    public Result updateUserById(UserDO userDO)
    {
        if(mapper.updateByPrimaryKey(userDO)>0)
        {
            return Result.ok();
        }
        return Result.fail();
    }

    public UserDO selectUserById(Long id)
    {
        return mapper.selectByPrimaryKey(id);
    }

    public UserDO selectUserByIdCard(String idCard) {
        return mapper.selectUserByIdCard(idCard);
    }

    public List<UserDO> listUserByName(String name)
    {
        return mapper.listUserByName(name);
    }

    public List<UserDO> listUser()
    {
        return mapper.selectAll();
    }
}
