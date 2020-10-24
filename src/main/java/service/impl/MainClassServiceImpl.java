package service.impl;

import controller.BooksController;
import controller.BorrowController;
import controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IMainClassService;

import java.util.Scanner;

@Service
public class MainClassServiceImpl implements IMainClassService
{
    @Autowired
    private BooksController     booksController ;
    @Autowired
    private BorrowController    borrowController;
    @Autowired
    private UserController      userController  ;

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void main()
    {
        //⑴ ⑵ ⑶ ⑷ ⑸ ⑹ ⑺ ⑻ ⑼ ⑽ ⑾ ⑿ ⒀ ⒁ ⒂ ⒃ ⒄ ⒅ ⒆ ⒇
        System.out.println("==========图书管理系统 START==========");
        System.out.println("⑴:书籍管理");
        System.out.println("⑵:用户管理");
        System.out.println("⑶:借阅管理");
        System.out.println("⑷:退出系统");
        System.out.println("==========图书管理系统 END==========");
        System.out.println("请输入对应的序号进入管理:");
        menuIn();
    }

    public void menuIn()
    {
        Integer in = scanner.nextInt();
        switch (in)
        {
            case 1 :
                booksController.booksManage();
                break;
            case 2 :
                userController.userManage();
                break;
            case 3 :
                borrowController.borrowManage();
                break;
            case 4 :
                System.out.println("感谢您的使用,系统即将退出~!");
                System.exit(0);
                break;
            default:
                System.out.println("您输入的序号错误,请重新输入:");
                this.menuIn();
        }
    }


}
