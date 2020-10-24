package service;

import pojo.domain.UserDO;
import util.Result;

import java.util.List;

public interface IUserService 
{
    Result addUser(UserDO UserDO);

    Result deleteUser(Long id);

    Result updateUserById(UserDO UserDO);

    UserDO selectUserById(Long id);

    UserDO selectUserByIdCard(String idCard);

    List<UserDO> listUserByName(String s);

    List<UserDO> listUser();
}
