package pojo.domain;

import com.liuzhi.utils.MyStringUtils;

public class BooksDO {
    private Long id;

    private String name;

    private String author;

    private String publisher;

    private String no;

    private Integer amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        if(MyStringUtils.isEmpty(name))
        {
            return;
        }
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author)
    {
        if(MyStringUtils.isEmpty(author))
        {
            return;
        }
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher)
    {
        if(MyStringUtils.isEmpty(publisher))
        {
            return;
        }
        this.publisher = publisher;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no)
    {
        if(MyStringUtils.isEmpty(no))
        {
            return;
        }
        this.no = no;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(id).append("\t\t");
        sb.append(name).append("\t\t\t\t");
        sb.append(author).append("\t\t");
        sb.append(publisher).append("\t\t");
        sb.append(no).append("\t\t");
        sb.append(amount).append("\t");
        sb.append("\n");
        return sb.toString();
    }

    public String toFormatterString() {
        final StringBuffer sb = new StringBuffer("-----书籍信息-----").append("\n");
        if(id !=null)
        {
            sb.append("ID编号:").append(id).append("\n");
        }
        sb.append("书籍名称:").append(name).append("\n");
        sb.append("作者名称:").append(author).append("\n");
        sb.append("出版社名称").append(publisher).append("\n");
        sb.append("书籍ISBN:").append(no).append("\n");
        sb.append("数量:").append(amount).append("\n");
        sb.append("---------------").append("\n");
        return sb.toString();
    }
}