package BEAN;

import java.util.Date;

public class customer {
    int id;
    String name;
    Date birth;
    String email;

    public customer() {
    }

    public customer(int id, String name, Date birth, String email) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String s=id+" "+name+" "+birth+" "+email;
    return  s;
    }
}
