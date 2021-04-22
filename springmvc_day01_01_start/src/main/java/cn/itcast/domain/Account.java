package cn.itcast.domain;

import java.io.Serializable;

public class Account implements Serializable {
    private String name;
    private String password;
    private int money;

    private user user;

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", user=" + user +
                '}';
    }

    public cn.itcast.domain.user getUser() {
        return user;
    }

    public void setUser(cn.itcast.domain.user user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
