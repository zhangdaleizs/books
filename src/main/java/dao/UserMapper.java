package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import pojo.domain.UserDO;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDO record);

    UserDO selectByPrimaryKey(Long id);

    List<UserDO> selectAll();

    int updateByPrimaryKey(UserDO record);

    UserDO selectUserByIdCard(String idCard);

    List<UserDO> listUserByName(String name);
}