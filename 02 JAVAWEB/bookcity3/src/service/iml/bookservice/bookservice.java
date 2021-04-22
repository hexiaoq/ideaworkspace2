package service.iml.bookservice;

import pojo.BOOK;
import pojo.Page;

import java.util.List;

public interface bookservice {
    public void addbook(BOOK book);
    public BOOK querybookbyid(Integer id);
    public void updatebook(BOOK book);
    public void deletebookbyid(Integer id);
    public List<BOOK> queryallbooks();

   public Page page(int pageNo, int pagesize);
}
