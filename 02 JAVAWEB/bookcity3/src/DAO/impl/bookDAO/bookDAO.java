package DAO.impl.bookDAO;

import pojo.BOOK;

import java.util.List;

public interface bookDAO {
    public void addbook(BOOK book);
    public BOOK querybookbyid(Integer id);
    public void updatebook(BOOK book);
    public void deletebookbyid(Integer id);
    public List<BOOK> queryallbooks();
    public int querypagetotal();

    public List<BOOK> querypageitems(int begin,Integer pagesize);
}
