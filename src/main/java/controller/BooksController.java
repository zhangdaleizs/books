package controller;

import com.liuzhi.utils.MyStringUtils;
import org.springframework.stereotype.Component;
import pojo.domain.BooksDO;
import util.Result;

import java.util.List;

@Component
public class BooksController extends BaseController
{
    /**
     * 书籍管理
     */
    public void booksManage()
    {
        println("==========书籍管理 START==========");
        println("⑴:增加书籍");
        println("⑵:修改书籍");
        println("⑶:删除书籍");
        println("⑷:查找书籍");
        println("⑸:浏览书籍");
        println("⑹:返回菜单");
        println("==========书籍管理 END==========");
        println("请输入对应的序号进入管理:");
        booksMenuIn();
    }

    public void booksMenuIn()
    {
        Integer in = scanner.nextInt();
        switch (in)
        {
            case 1 :
                this.addBooksMenu();
                break;
            case 2 :
                this.editBooksMenu();
                break;
            case 3 :
                this.deleteBooksMenu();
                break;
            case 4 :
                this.selectBooksMenu();
                break;
            case 5 :
                this.listBooksMenu();
                break;
            case 6 :
                mainClassService.main();
                break;
            default:
                println("您输入的序号错误,请重新输入:");
                this.booksMenuIn();
        }
    }

    private void listBooksMenu()
    {
        List<BooksDO> list = booksService.listBooks();
        if(MyStringUtils.isEmpty(list))
        {
            println("没有任何书籍:");
        }else
        {
            println("ID编号\t\t书籍名称\t\t\t\t书籍作者\t\t出版社\t\tISBN\t\t数量");
            list.forEach(b->print(b.toString()));
        }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        booksManage();
    }

    private void selectBooksMenu()
    {
        println("-----查找书籍 START------");
        println("(1):根据书籍ID查找书籍");
        println("(2):根据书籍名称查找书籍");
        println("(3):根据作者名称查找书籍");
        println("(4):根据出版社查找书籍");
        println("(5):根据书籍ISBN查找书籍");
        println("(6):返回上一层");
        println("-----查找书籍 END------");
        println("请输入对应的序号进入管理:");
        selectMenuIn();
    }

    private void selectMenuIn()
    {
        Integer in = scanner.nextInt();
        switch (in) {
            case 1:
                selectBooksById();
                break;
            case 2:
                selectBooksByName();
                break;
            case 3:
                selectBooksByAuthor();
                break;
            case 4:
                selectBooksByPublisher();
                break;
            case 5:
                selectBooksByISBN();
                break;
            case 6:
                booksManage();
                break;
            default:
                println("您输入的序号错误,请重新输入:");
                this.selectMenuIn();
        }
    }

    private void selectBooksByISBN()
    {
        println("您输入书籍ISBN编码:");
        String isbn = scanner.next();
        List<BooksDO> list = booksService.listBooksByIsbn("%"+isbn+"%");
        if(MyStringUtils.isEmpty(list))
        {
            println("根据ISBN编码未查找到任何书籍:");
        }else
            {
                println("ID编号\t\t书籍名称\t\t\t\t书籍作者\t\t出版社\t\tISBN\t\t数量");
                list.forEach(b->print(b.toString()));
            }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        selectBooksMenu();
    }

    private void selectBooksByPublisher()
    {
        println("您输入出版社名称:");
        String publisher = scanner.next();
        List<BooksDO> list = booksService.listBooksByPublisher("%"+publisher+"%");
        if(MyStringUtils.isEmpty(list))
        {
            println("根据出版社名称未查找到任何书籍:");
        }else
        {
            println("ID编号\t\t书籍名称\t\t\t\t书籍作者\t\t出版社\t\tISBN\t\t数量");
            list.forEach(b->print(b.toString()));
        }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        selectBooksMenu();
    }

    private void selectBooksByAuthor()
    {
        println("您输入作者名称:");
        String author = scanner.next();
        List<BooksDO> list = booksService.listBooksByAuthor("%"+author+"%");
        if(MyStringUtils.isEmpty(list))
        {
            println("根据作者名称未查找到任何书籍:");
        }else
        {
            println("ID编号\t\t书籍名称\t\t\t\t书籍作者\t\t出版社\t\tISBN\t\t数量");
            list.forEach(b->print(b.toString()));
        }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        selectBooksMenu();
    }

    private void selectBooksByName()
    {
        println("您输入书籍名称:");
        String name = scanner.next();
        List<BooksDO> list = booksService.listBooksByName("%"+name+"%");
        if(MyStringUtils.isEmpty(list))
        {
            println("根据书籍名称未查找到任何书籍:");
        }else
        {
            println("ID编号\t\t书籍名称\t\t\t\t书籍作者\t\t出版社\t\tISBN\t\t数量");
            list.forEach(b->print(b.toString()));
        }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        selectBooksMenu();
    }

    private void selectBooksById()
    {
        println("您输入书籍编号ID:");
        Long booksId = scanner.nextLong();
        BooksDO booksDO = booksService.selectBooksById(booksId);
        if(booksDO == null)
        {
            println("根据书籍编号ID:"+booksId+",未查找到书籍信息");
        }else
            {
                println(booksDO.toFormatterString());
            }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        selectBooksMenu();
    }

    private void deleteBooksMenu()
    {
        println("-----删除书籍 START------");
        println("⑴:根据书籍ID删除书籍");
        println("⑵:返回上一层");
        println("-----删除书籍 END------");
        println("请输入对应的序号进入管理:");
        deleteMenuIn();
    }

    private void deleteMenuIn()
    {
        Integer in = scanner.nextInt();
        switch (in) {
            case 1:
                deleteBooksById();
                break;
            case 2:
                booksManage();
                break;
            default:
                println("您输入的序号错误,请重新输入:");
                this.deleteMenuIn();
        }
    }

    private void deleteBooksById()
    {
        println("您输入书籍编号ID:");
        Long booksId = scanner.nextLong();
        showBooksById(booksId);
        println("是否要删除当前书籍信息?");
        println("y:是,其他任意键取消");
        if(!scanner.next().equalsIgnoreCase("y"))
        {//不修改,返回
            println("本次操作已取消");
            deleteBooksMenu();
        }
        Result result = booksService.deleteBooks(booksId);
        if(result.getCode().equals(0))
        {
            println("删除书籍成功");
        }else
            {
                println(result.getMsg());
            }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        deleteBooksMenu();
    }

    private void editBooksMenu() 
    {
        println("-----修改书籍 START------");
        println("⑴:根据书籍ID修改书籍");
        println("⑵:返回上一层");
        println("-----修改书籍 END------");
        println("请输入对应的序号进入管理:");
        editMenuIn();  
    }

    private void editMenuIn() {
        Integer in = scanner.nextInt();
        switch (in)
        {
            case 1 :
                editBooksById();
                break;
            case 2 :
                booksManage();
                break;
            default:
                println("您输入的序号错误,请重新输入:");
                this.addMenuIn();
        }
    }

    private void editBooksById()
    {
        println("您输入书籍编号ID:");
        Long booksId = scanner.nextLong();
        BooksDO booksDO = showBooksById(booksId);
        println("是否要修改当前书籍信息?");
        println("y:是,其他任意键取消");
        if(!scanner.next().equalsIgnoreCase("y"))
        {//不修改,返回
            editBooksMenu();
        }
        println("-----开始修改书籍信息,回车跳过此项-----");
        editBooks(booksDO);
        println("-----您要修改的书籍信息如下是否确认?-----");
        println(booksDO.toFormatterString());
        println("y:是,其他任意键取消");
        if(scanner.next().equalsIgnoreCase("y"))
        {//新增书籍
            Result result = booksService.updateBooksById(booksDO);
            if(result.getCode().equals(0))
            {
                println("修改书籍成功");
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
        editBooksMenu();
    }

    public void addMenuIn()
    {
        Integer in = scanner.nextInt();
        switch (in)
        {
            case 1 :
                addBooks();
                break;
            case 2 :
                booksManage();
                break;
            default:
                println("您输入的序号错误,请重新输入:");
                this.addMenuIn();
        }
    }

    public void addBooksMenu()
    {
        println("-----增加书籍 START------");
        println("⑴:开始增加书籍");
        println("⑵:返回上一层");
        println("-----增加书籍 END------");
        println("请输入对应的序号进入管理:");
        addMenuIn();
    }
    public void  editBooks(BooksDO booksDO)
    {
        scanner.nextLine();
        println("请输入书籍名称:");
        booksDO.setName(scanner.nextLine());
        println("请输入作者名称:");
        booksDO.setAuthor(scanner.nextLine());
        println("请输入出版社名称:");
        booksDO.setPublisher(scanner.nextLine());
        println("请输入书籍ISBN:");
        booksDO.setNo(scanner.nextLine());
        println("请输入书籍数量:");
        String count =  scanner.nextLine();
        if(!count.trim().equals(""))
        {
            booksDO.setAmount(Integer.valueOf(count.trim()));
        }

    }
    public void addBooks()
    {
        BooksDO booksDO = new BooksDO();
        editBooks(booksDO);
        println("-----操作完毕------");
        println("提示:您本次新增的书籍信息如下,是否确认?");
        println(booksDO.toFormatterString());
        println("y:是,其他任意键取消");
        if(scanner.next().equalsIgnoreCase("y"))
        {//新增书籍
            booksService.addBooks(booksDO);
            println("增加书籍成功");
        }else
        {
            println("本次操作已取消");
        }
        println("按任意键返回上一层:");
        scanner.nextLine();
        scanner.nextLine();
        addBooksMenu();
    }


    public BooksDO showBooksById(Long booksId)
    {
        BooksDO booksDO = booksService.selectBooksById(booksId);
        while(booksDO == null)
        {
            println("您输入书籍编号ID不存在,请重新输入:");
            booksId = scanner.nextLong();
            booksDO = booksService.selectBooksById(booksId);
        }
        println(booksDO.toFormatterString());
        return booksDO;
    }


}
