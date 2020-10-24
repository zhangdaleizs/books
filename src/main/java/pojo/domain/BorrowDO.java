package pojo.domain;

import controller.MainClass;
import service.IBooksService;
import service.IUserService;
import service.impl.BooksServiceImpl;
import service.impl.UserServiceImpl;

public class BorrowDO
{
    private IBooksService booksService;
    private IUserService userService;

    public BorrowDO()
    {
        booksService = MainClass.context.getBean(BooksServiceImpl.class);
        userService = MainClass.context.getBean(UserServiceImpl.class);
    }

    private Long id;

    private Long userId;

    private Long booksId;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBooksId() {
        return booksId;
    }

    public void setBooksId(Long booksId) {
        this.booksId = booksId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toFormatterString() {
        final StringBuffer sb = new StringBuffer("-----借阅信息-----").append("\n");
        if(id !=null)
        {
            sb.append("ID编号:").append(id).append("\n");
        }
        sb.append("用户ID:").append(userId).append("\n");
        sb.append("用户名称:").append(userService.selectUserById(userId).getName()).append("\n");
        sb.append("书籍ID:").append(booksId).append("\n");
        sb.append("书籍名称:").append(booksService.selectBooksById(booksId).getName()).append("\n");
        sb.append("状态:").append(status==null?"":status.equals(0)?"未还":"已还").append("\n");
        sb.append("---------------").append("\n");
        return sb.toString();
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(id).append("\t\t");
        sb.append(userId).append("\t\t");
        sb.append(userService.selectUserById(userId).getName()).append("\t\t");
        sb.append(booksId).append("\t\t");
        sb.append(booksService.selectBooksById(booksId).getName()).append("\t\t");
        sb.append(status==null?"":status.equals(0)?"未还":"已还").append("\t");
        sb.append("\n");
        return sb.toString();
    }
}