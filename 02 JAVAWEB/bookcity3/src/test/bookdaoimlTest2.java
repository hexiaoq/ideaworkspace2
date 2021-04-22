package test;

import DAO.impl.bookDAO.bookdaoiml;
import org.junit.jupiter.api.Test;
import pojo.BOOK;
import service.iml.bookservice.bookservice;
import service.iml.bookservice.bookserviceimp;

import static org.junit.jupiter.api.Assertions.*;

class bookdaoimlTest2 {
    private DAO.impl.bookDAO.bookdaoiml bookdaoiml=new bookdaoiml();
    private bookservice bookservice=new bookserviceimp();
    @Test
    void querypageitems() {
        for (BOOK book : bookdaoiml.querypageitems(5, 5)) {
            System.out.println(book);
        }
    }

    @Test
    void querypagetotal() {
        System.out.println( bookdaoiml.querypagetotal());
    }
    @Test
    void page()
    {
        System.out.println(bookservice.page(3,4));

    }
}