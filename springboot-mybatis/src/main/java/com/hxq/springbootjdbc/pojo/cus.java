package com.hxq.springbootjdbc.pojo;

import java.io.Serializable;

public class cus implements Serializable {
    private Integer cusid;
    private String cusname;
    private String cusemail;

    @Override
    public String toString() {
        return "cus{" +
                "cusid=" + cusid +
                ", cusname='" + cusname + '\'' +
                ", cusemail='" + cusemail + '\'' +
                '}';
    }

    public Integer getCusid() {
        return cusid;
    }

    public void setCusid(Integer cusid) {
        this.cusid = cusid;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getCusemail() {
        return cusemail;
    }

    public void setCusemail(String cusemail) {
        this.cusemail = cusemail;
    }

    public cus() {
    }

    public cus(Integer cusid, String cusname, String cusemail) {
        this.cusid = cusid;
        this.cusname = cusname;
        this.cusemail = cusemail;
    }
}
