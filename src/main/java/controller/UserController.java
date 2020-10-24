package controller;

import com.liuzhi.utils.MyDateUtils;
import com.liuzhi.utils.MyStringUtils;
import org.springframework.stereotype.Component;
import pojo.domain.BooksDO;
import pojo.domain.UserDO;
import pojo.domain.UserDO;
import util.Result;

import java.util.Date;
import java.util.List;

@Component
public class UserController extends BaseController
{
    /**
     * 用户管理
     */
    public void userManage()
    {
        println("==========用户管理 START==========");
        println("⑴:增加用户");
        println("⑵:修改用户");
        println("⑶:删除用户");
        println("⑷:查找用户");
        println("⑸:浏览用户");
        println("⑹:返回菜单");
        println("==========用户管理 END==========");
        println("请输入对应的序号进入管理:");
        userMenuIn();
    }
    public void userMenuIn()
    {
        Integer in = scanner.nextInt();
        switch (in)
        {
            case 1 :
                addUserMenu();
                break;
            case 2 :
                editUserMenu();
                break;
            case 3 :
                deleteUserMenu();
                break;
            case 4 :
                selectUserMenu();
                break;
            case 5 :
                listUserMenu();
                break;
            case 6 :
                mainClassService.main();
                break;
            default:
                println("您输入的序号错误,请重新输入:");
                this.userMenuIn();
        }
    }

    private void listUserMenu() {
        List<UserDO> list = userService.listUser();
        if(MyStringUtils.isEmpty(list))
        {
            println("没有任何用户");
        }else
        {
            println("ID编号\t\t用户名称\t\t用户性别\t\t身份证号\t\t用户生日");
            list.forEach(u->print(u.toString()));
        }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        userManage();
    }

    private void selectUserMenu()
    {
        println("-----查找用户 START------");
        println("(1):根据用户ID查找用户");
        println("(2):根据用户名称查找用户");
        println("(3):根据身份证用户");
        println("(4):返回上一层");
        println("-----查找用户 END------");
        println("请输入对应的序号进入管理:");
        selectMenuIn();
    }

    private void selectMenuIn() {
        Integer in = scanner.nextInt();
        switch (in) {
            case 1:
                selectUserById();
                break;
            case 2:
                selectUserByName();
                break;
            case 3:
                selectUserByIdCard();
                break;
            case 4:
                userManage();
                break;
            default:
                println("您输入的序号错误,请重新输入:");
                this.selectMenuIn();
        }
    }

    private void selectUserByIdCard() 
    {
        println("您输入用户身份证号码:");
        String idCard = scanner.next();
        UserDO userDO = userService.selectUserByIdCard(idCard);
        if(userDO == null )
        {
            println("根据用户身份证号码未查找到任何用户:");
        }else
        {
          println(userDO.toFormatterString());
        }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        selectUserMenu();
    }

    private void selectUserByName() 
    {
        println("您输入用户姓名:");
        String name = scanner.next();
        List<UserDO> list = userService.listUserByName("%"+name+"%");
        if(MyStringUtils.isEmpty(list))
        {
            println("根据姓名未查找到任何用户:");
        }else
        {
            println("ID编号\t\t用户名称\t\t用户性别\t\t身份证号\t\t用户生日");
            list.forEach(u->print(u.toString()));
        }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        selectUserMenu();
    }

    private void selectUserById() 
    {
        println("您输入用户ID编码:");
        Long id = scanner.nextLong();
        UserDO userDO = userService.selectUserById(id);
        if(userDO == null )
        {
            println("根据用户ID编码未查找到任何用户:");
        }else
        {
            println(userDO.toFormatterString());
        }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        selectUserMenu(); 
    }

    private void deleteUserMenu() {
        println("-----删除用户 START------");
        println("⑴:根据用户ID删除用户");
        println("⑵:返回上一层");
        println("-----删除用户 END------");
        println("请输入对应的序号进入管理:");
        deleteMenuIn();
    }

    private void deleteMenuIn() {
        Integer in = scanner.nextInt();
        switch (in) {
            case 1:
                deleteUserById();
                break;
            case 2:
                userManage();
                break;
            default:
                println("您输入的序号错误,请重新输入:");
                this.deleteMenuIn();
        }
    }

    private void deleteUserById()
    {
        println("您输入用户编号ID:");
        Long id = scanner.nextLong();
        showUserById(id);
        println("是否要删除当前用户信息?");
        println("y:是,其他任意键取消");
        if(!scanner.next().equalsIgnoreCase("y"))
        {//不修改,返回
            println("本次操作已取消");
            deleteUserMenu();
        }
        Result result = userService.deleteUser(id);
        if(result.getCode().equals(0))
        {
            println("删除用户成功");
        }else
        {
            println(result.getMsg());
        }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        deleteUserMenu();
    }

    private void editUserMenu() {
        println("-----修改用户 START------");
        println("⑴:根据用户ID修改用户");
        println("⑵:返回上一层");
        println("-----修改用户 END------");
        println("请输入对应的序号进入管理:");
        editMenuIn();
    }

    private void editMenuIn()
    {
        Integer in = scanner.nextInt();
        switch (in)
        {
            case 1 :
                editUserById();
                break;
            case 2 :
                userManage();
                break;
            default:
                println("您输入的序号错误,请重新输入:");
                this.addMenuIn();
        }
    }

    private void editUserById()
    {
        println("您输入用户编号ID:");
        Long id = scanner.nextLong();
        UserDO userDO = showUserById(id);
        println("是否要修改当前用户信息?");
        println("y:是,其他任意键取消");
        if(!scanner.next().equalsIgnoreCase("y"))
        {//不修改,返回
            editUserMenu();
        }
        println("-----开始修改用户信息,回车跳过此项-----");
        editUser(userDO);
        println("-----您要修改的用户信息如下是否确认?-----");
        println(userDO.toFormatterString());
        println("y:是,其他任意键取消");
        if(scanner.next().equalsIgnoreCase("y"))
        {
            Result result = userService.updateUserById(userDO);
            if(result.getCode().equals(0))
            {
                println("修改用户成功");
            }else
            {
                println(result.getMsg());
            }
        }else
        {
            println("本次操作已取消");
        }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        editUserMenu();
    }

    private UserDO showUserById(Long id)
    {
        UserDO userDO = userService.selectUserById(id);
        while(userDO == null)
        {
            println("您输入用户编号ID不存在,请重新输入:");
            id = scanner.nextLong();
            userDO = userService.selectUserById(id);
        }
        println(userDO.toFormatterString());
        return userDO;
    }

    private void addUserMenu()
    {
        println("-----增加用户 START------");
        println("⑴:开始增加用户");
        println("⑵:返回上一层");
        println("-----增加用户 END------");
        println("请输入对应的序号进入管理:");
        addMenuIn();
    }

    private void addMenuIn()
    {
        Integer in = scanner.nextInt();
        switch (in)
        {
            case 1 :
                addUser();
                break;
            case 2 :
                userManage();
                break;
            default:
                println("您输入的序号错误,请重新输入:");
                this.addMenuIn();
        }
    }

    private void addUser()
    {
        UserDO userDO = new UserDO();
        editUser(userDO);
        println("-----操作完毕------");
        println("提示:您本次新增的用户信息如下,是否确认?");
        println(userDO.toFormatterString());
        println("y:是,其他任意键取消");
        if(scanner.next().equalsIgnoreCase("y"))
        {//新增用户
            userService.addUser(userDO);
            println("增加用户成功");
        }else
        {
            println("本次操作已取消");
        }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        addUserMenu();
    }

    private void editUser(UserDO userDO)
    {
        scanner.nextLine();
        println("请输入用户名称:");
        userDO.setName(scanner.nextLine());
        println("请输入用户性别(男 or 女):");
        userDO.setSex(scanner.nextLine());
        while (!userDO.getSex().equals("男") && !userDO.getSex().equals("女"))
        {
            println("性别只能输入 男 or 女,请重新输入:");
            userDO.setSex(scanner.nextLine());
        }
        println("请输入用户身份证号码:");
        userDO.setIdCard(scanner.nextLine());
        while (userService.selectUserByIdCard(userDO.getIdCard()) != null)
        {
            println("该身份证已注册,请重新输入:");
            userDO.setIdCard(scanner.nextLine());
        }
        while (!MyStringUtils.isIDNumber(userDO.getIdCard()))
        {
            println("请输入正确的身份证号码:");
            userDO.setIdCard(scanner.nextLine());
        }

        String year = userDO.getIdCard().substring(6,10);
        String month = userDO.getIdCard().substring(10,12);
        String day = userDO.getIdCard().substring(12,14);
        userDO.setBirthday(MyDateUtils.strToDate(year+month+day));
    }
}
