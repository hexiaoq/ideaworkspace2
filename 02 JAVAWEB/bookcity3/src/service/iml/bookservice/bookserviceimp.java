package service.iml.bookservice;

import DAO.impl.bookDAO.bookdaoiml;
import pojo.BOOK;
import pojo.Page;

import java.math.BigDecimal;
import java.util.List;

public class bookserviceimp implements bookservice {
    DAO.impl.bookDAO.bookdaoiml bookdaoiml=new bookdaoiml();
    @Override
    public void addbook(BOOK book) {
        bookdaoiml.addbook(book);

    }

    @Override
    public BOOK querybookbyid(Integer id) {
       return bookdaoiml.querybookbyid(id);
    }

    @Override
    public void updatebook(BOOK book) {
        bookdaoiml.updatebook(book);

    }

    @Override
    public void deletebookbyid(Integer id) {
bookdaoiml.deletebookbyid(id);
    }

    @Override
    public List<BOOK> queryallbooks() {
        return bookdaoiml.queryallbooks();
    }


    //获得当前页面的所有数据,和页面分页的所有信息
    @Override
    public Page<BOOK> page(int pageNo, int pagesize) {
        Page<BOOK> page=new Page<BOOK>();


        page.setPagesize(pagesize);
        Integer pagetalcount=bookdaoiml.querypagetotal();
        page.setPagetalcount(pagetalcount);

//根据总数据数量，获取页面数量
        Integer pagetotal=(pagetalcount%pagesize)!=0?(pagetalcount/pagesize)+1:(pagetalcount/pagesize);
        page.setPagetotal(pagetotal);
        if(pageNo>pagetotal)
        {
            pageNo=pagetotal;
        }
        if (pageNo<1)
        {
            pageNo=1;
        }
        page.setPageNo(pageNo);

        //获得当前页面数据,保存到items中
        //sql语句中的当前页面起始数据id,时分页的两个参数之一
        int begin=(pageNo-1)*pagesize;
        List<BOOK> items=bookdaoiml.querypageitems(begin,pagesize);
        page.setItems(items);
          return page;

    }
    public Page<BOOK> pagebyprice(int pageNo, int pagesize, int min,int max) {
        Page<BOOK> page=new Page<BOOK>();


        page.setPagesize(pagesize);
        Integer pagetalcount=bookdaoiml.querypagetotalbyprice(min,max);
        page.setPagetalcount(pagetalcount);

//根据总数据数量，获取页面数量
        Integer pagetotal=(pagetalcount%pagesize)!=0?(pagetalcount/pagesize)+1:(pagetalcount/pagesize);
        page.setPagetotal(pagetotal);
        if(pageNo>pagetotal)
        {
            pageNo=pagetotal;
        }
        if (pageNo<1)
        {
            pageNo=1;
        }
        page.setPageNo(pageNo);

        //获得当前页面数据,保存到items中
        //sql语句中的当前页面起始数据id,时分页的两个参数之一
        int begin=(pageNo-1)*pagesize;
        List<BOOK> items=bookdaoiml.querypageitemsbyprice(min,max,begin,pagesize);
        page.setItems(items);
          return page;

    }
}
