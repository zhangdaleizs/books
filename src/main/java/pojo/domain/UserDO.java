package pojo.domain;

import java.util.Date;

public class UserDO {
    private Long id;

    private String name;

    private String idCard;

    private Date birthday;

    private String sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String toFormatterString()
    {
        final StringBuffer sb = new StringBuffer("-----用户信息-----").append("\n");
        if(id !=null)
        {
            sb.append("ID编号:").append(id).append("\n");
        }
        sb.append("用户姓名:").append(name).append("\n");
        sb.append("用户性别:").append(sex).append("\n");
        sb.append("身份证号:").append(idCard).append("\n");
        sb.append("用户生日").append(birthday).append("\n");
        sb.append("---------------").append("\n");
        return sb.toString();
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(id).append("\t\t");
        sb.append(name).append("\t\t");
        sb.append(sex).append("\t\t");
        sb.append(idCard).append("\t\t");
        sb.append(birthday).append("\t\t");
        sb.append("\n");
        return sb.toString();
    }
}