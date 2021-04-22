package test;

import DAO.impl.DAO;
import DAO.impl.bookDAO.bookdaoiml;
import pojo.BOOK;

import java.math.BigDecimal;
import java.util.List;

class bookdaoimlTest {

private bookdaoiml bookdaoiml=new bookdaoiml();
    @org.junit.jupiter.api.Test
    void addbook() {
        bookdaoiml.addbook(new BOOK(null,"何小强的程序猿生涯",new BigDecimal(999),"何小强",10000,0,""));
    }

    @org.junit.jupiter.api.Test
    void querybookbyid() {
        BOOK querybookbyid = bookdaoiml.querybookbyid(10);
        System.out.println(querybookbyid);
    }

    @org.junit.jupiter.api.Test
    void updatebook() {
        bookdaoiml.updatebook(new BOOK(19,"何小强的程序猿生涯",new BigDecimal(999),"何小强",0,1000000,""));
    }

    @org.junit.jupiter.api.Test
    void deletebookbyid() {
        bookdaoiml.deletebookbyid(19);
    }

    @org.junit.jupiter.api.Test
    void queryallbooks() {
        List<BOOK> books = bookdaoiml.queryallbooks();
        for (BOOK book : books) {
            System.out.println(book);

        }
    }
}