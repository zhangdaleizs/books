package controller;

import com.liuzhi.utils.MyStringUtils;
import org.springframework.stereotype.Component;
import pojo.domain.BooksDO;
import pojo.domain.BorrowDO;
import util.Result;

import java.util.List;

@Component
public class BorrowController extends BaseController
{
    /**
     * 借阅管理
     */
    public void borrowManage()
    {
        println("==========借阅管理 START==========");
        println("(1):用户借阅书籍");
        println("(2):用户归还书籍");
        println("(3):查看未还书籍");
        println("(4):查看已还书籍");
        println("(5):查看全部借阅书籍");
        println("(6):返回菜单");
        println("==========借阅管理 END==========");
        println("请输入对应的序号进入管理:");
        borrowMenuIn();
    }
    public void borrowMenuIn()
    {
        Integer in = scanner.nextInt();
        switch (in)
        {
            case 1 :
                borrowBooks();
                break;
            case 2 :
                returnBooks();
                break;
            case 3 :
                listByBorrowBooks();
                break;
            case 4 :
                listByReturnBooks();
                break;
            case 5 :
                listByBooks();
                break;
            case 6 :
                mainClassService.main();
                break;
            default:
                println("您输入的序号错误,请重新输入:");
                this.borrowMenuIn();
        }
    }

    private void listByBooks()
    {
        List<BorrowDO> list = borrowService.listBooks();
        if(MyStringUtils.isEmpty(list))
        {
            println("未查找到任何借阅书籍:");
        }else
        {
            println("ID编号\t\t用户ID\t\t用户名称\t\t书籍ID\t\t书籍名称\t\t借阅状态");
            list.forEach(b->print(b.toString()));
        }
        println("按任意键继续操作:");
        scanner.nextLine();
        scanner.nextLine();
        borrowManage();
    }

    private void listByReturnBooks() {
        println("-----已还书籍 START------");
        println("⑴:查询全部已还书籍");
        println("⑵:返回上一层");
        println("-----已还书籍 END------");
        println("请输入对应的序号进入管理:");
        ReturnBooksIn();
    }

    private void ReturnBooksIn()
    {
        Integer in = scanner.nextInt();
        switch (in)
        {
            case 1 :
                ReturnBooks();
                break;
            case 2 :
                borrowManage();
                break;
            default:
                println("您输入的序号错误,请重新输入:");
                this.returnIn();
        }
    }

    private void ReturnBooks()
    {
        List<BorrowDO> list = borrowService.listBooksByReturn();
        if(MyStringUtils.isEmpty(list))
        {
            println("未查找到任何已经归还的书籍:");
        }else
        {
            println("ID编号\t\t用户ID\t\t用户名称\t\t书籍ID\t\t书籍名称\t\t借阅状态");
            list.forEach(b->print(b.toString()));
        }
        println("按任意键继续操作:");
        scanner.nextLine();
        scanner.nextLine();
        listByReturnBooks();
    }

    private void listByBorrowBooks() {
        println("-----未还书籍 START------");
        println("⑴:查询全部未还书籍");
        println("⑵:返回上一层");
        println("-----未还书籍 END------");
        println("请输入对应的序号进入管理:");
        BorrowBooksIn();
    }

    private void BorrowBooksIn()
    {
        Integer in = scanner.nextInt();
        switch (in)
        {
            case 1 :
                BorrowBooks();
                break;
            case 2 :
                borrowManage();
                break;
            default:
                println("您输入的序号错误,请重新输入:");
                this.BorrowBooksIn();
        }
    }

    private void BorrowBooks()
    {
        List<BorrowDO> list = borrowService.listBooksByBorrow();
        if(MyStringUtils.isEmpty(list))
        {
            println("未查找到任何正在借阅的书籍:");
        }else
        {
            println("ID编号\t\t用户ID\t\t用户名称\t\t书籍ID\t\t书籍名称\t\t借阅状态");
            list.forEach(b->print(b.toString()));
        }
        println("按任意键继续操作:");
        scanner.nextLine();
        scanner.nextLine();
        listByBorrowBooks();
    }

    private void returnBooks()
    {
        println("-----归还书籍 START------");
        println("(1):根据借阅ID归还书籍");
        println("(2):根据用户ID归还书籍");
        println("(3):根据书籍ID归还书籍");
        println("(4):返回上一层");
        println("-----归还书籍 END------");
        println("请输入对应的序号进入管理:");
        returnIn();
    }

    private void returnIn()
    {
        Integer in = scanner.nextInt();
        switch (in)
        {
            case 1 :
                returnById();
                break;
            case 2 :
                returnByUserId();
                break;
            case 3 :
                returnByBooksId();
                break;
            case 4 :
                borrowManage();
                break;
            default:
                println("您输入的序号错误,请重新输入:");
                this.returnIn();
        }
    }

    private void returnByBooksId()
    {
        println("您输入书籍ID编号:");
        Long id = scanner.nextLong();
        List<BorrowDO> list = borrowService.listBooksByBooks(id);
        if(MyStringUtils.isEmpty(list))
        {
            println("根据用户ID编号未查找到任何借阅书籍:");
        }else
        {
            println("ID编号\t\t用户ID\t\t用户名称\t\t书籍ID\t\t书籍名称\t\t借阅状态");
            list.forEach(b->print(b.toString()));
        }
        println("按任意键继续操作:");
        scanner.nextLine();
        scanner.nextLine();
        returnById();
    }

    private void returnByUserId() {
        println("您输入用户ID编号:");
        Long id = scanner.nextLong();
        List<BorrowDO> list = borrowService.listBooksByUserId(id);
        if(MyStringUtils.isEmpty(list))
        {
            println("根据用户ID编号未查找到任何借阅书籍:");
        }else
        {
            println("ID编号\t\t用户ID\t\t用户名称\t\t书籍ID\t\t书籍名称\t\t借阅状态");
            list.forEach(b->print(b.toString()));
        }
        println("按任意键继续操作:");
        scanner.nextLine();
        scanner.nextLine();
        returnById();
    }

    private void returnById()
    {
        println("您输入您需要归还的借阅ID编号:");
        Long id = scanner.nextLong();
        BorrowDO borrowDO = borrowService.selectBorrowById(id);
        if(borrowDO == null)
        {
            println("根据借阅ID编号:"+id+",未查找到书籍信息");
        }else
        {
            println(borrowDO.toFormatterString());
            println("是否要归还当前借阅书籍?");
            println("y:是,其他任意键取消");
            if(!scanner.next().equalsIgnoreCase("y"))
            {//不修改,返回
                println("本次操作已取消");
                returnBooks();
            }
            Result result = borrowService.returnBorrow(borrowDO);
            if(result.getCode().equals(0))
            {
                println("归还书籍成功");
            }else
            {
                println(result.getMsg());
            }
        }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        returnBooks();
    }

    private void borrowBooks() {
        println("-----借阅书籍 START------");
        println("⑴:开始借阅书籍");
        println("⑵:返回上一层");
        println("-----借阅书籍 END------");
        println("请输入对应的序号进入管理:");
        borrowIn();
    }

    private void borrowIn()
    {
        Integer in = scanner.nextInt();
        switch (in)
        {
            case 1 :
                borrow();
                break;
            case 2 :
                borrowManage();
                break;
            default:
                println("您输入的序号错误,请重新输入:");
                this.borrowIn();
        }
    }

    private void borrow() {
        BorrowDO borrowDO = new BorrowDO();
        editBorrowDO(borrowDO);
        println("-----操作完毕------");
        println("提示:您本次借阅信息如下,是否确认?");
        println(borrowDO.toFormatterString());
        println("y:是,其他任意键取消");
        if(scanner.next().equalsIgnoreCase("y"))
        {//新增书籍
            Result result = borrowService.addBorrow(borrowDO);
            if(result.getCode().equals(0))
            {
                println("借阅书籍成功!");
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
        borrowBooks();
    }

    private void editBorrowDO(BorrowDO borrowDO)
    {
        scanner.nextLine();
        println("请输入书籍编号:");
        borrowDO.setBooksId(scanner.nextLong());
        //查询书籍是否存在
        while (booksService.selectBooksById(borrowDO.getBooksId())==null)
        {
            println("请输入正确的书籍编号:");
            borrowDO.setBooksId(scanner.nextLong());
        }
        println("请输入用户编号:");
        borrowDO.setUserId(scanner.nextLong());
        //查询用户是否存在
        while (userService.selectUserById(borrowDO.getUserId())==null)
        {
            println("请输入正确的用户编号:");
            borrowDO.setUserId(scanner.nextLong());
        }
    }
}
