package pojo.vo;

public class BorrowVO
{
    private Long id;

    private Long userId;

    private Long booksId;

    private Boolean status;

    private String userName;

    private String booksName;

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBooksName() {
        return booksName;
    }

    public void setBooksName(String booksName) {
        this.booksName = booksName;
    }

    public String toFormatterString() {
        final StringBuffer sb = new StringBuffer("-----借阅信息-----").append("\n");
        if(id !=null)
        {
            sb.append("ID编号:").append(id).append("\n");
        }
        sb.append("用户ID:").append(userId).append("\n");
        sb.append("用户名称:").append(userName).append("\n");
        sb.append("书籍ID:").append(booksId).append("\n");
        sb.append("书籍名称:").append(booksName).append("\n");
        sb.append("状态:").append(status.equals(0)?"未还":"已还").append("\n");
        sb.append("---------------").append("\n");
        sb.append("---------------").append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(id).append("\t\t");
        sb.append(userId).append("\t\t");
        sb.append(userName).append("\t\t");
        sb.append(booksId).append("\t\t");
        sb.append(booksName).append("\t\t");
        sb.append(status.equals(0)?"未还":"已还").append("\t");
        sb.append("\n");
        return sb.toString();
    }
}
