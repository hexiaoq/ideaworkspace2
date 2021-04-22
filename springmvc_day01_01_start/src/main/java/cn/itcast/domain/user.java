package cn.itcast.domain;


import java.io.Serializable;
import java.util.Date;

public class user implements Serializable {
    private String uname;
    private String age;
    private Date date;

    @Override
    public String toString() {
        return "user{" +
                "uname='" + uname + '\'' +
                ", age='" + age + '\'' +
                ", date=" + date +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
