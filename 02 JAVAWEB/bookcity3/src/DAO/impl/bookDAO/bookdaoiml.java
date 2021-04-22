package DAO.impl.bookDAO;

import DAO.impl.BaseDAO;
import pojo.BOOK;

import java.math.BigDecimal;
import java.util.List;

public class bookdaoiml extends BaseDAO implements bookDAO {
    @Override
    public void addbook(BOOK book) {
        String sql="insert into t_book(name,price,author,sales,stock,img_path) values(?,?,?,?,?,?)"
                ;
        update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImg_path());
    }

    @Override
    public BOOK querybookbyid(Integer id) {
       String sql="select id,name,price,author,sales,stock,img_path from t_book where id=? ";
        return getone(sql,BOOK.class,id);
    }

    @Override
    public void updatebook(BOOK book) {
        String sql="update t_book set name=?,price=?,author=?,sales=?,stock=?,img_path=? where id=?";
               update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public void deletebookbyid(Integer id) {
        String sql="delete from t_book where id=?";
        update(sql,id);

    }

    @Override
    public List<BOOK> queryallbooks() {
        String sql="select id,name,price,author,sales,stock,img_path from t_book";
        return  getmany(sql,BOOK.class);

    }

    //返回分页后的当前页面中的数据
    @Override
    public List<BOOK> querypageitems(int begin, Integer pagesize) {
        String sql="select id,name,price,author,sales,stock,img_path from t_book limit ?,?";
        return getmany(sql,BOOK.class,begin,pagesize);
    }


    //获得表格中的数据总数
    @Override
    public int querypagetotal() {
       String sql="select count(*) from t_book ";
       //object类不能转换为int,但它的子类number可以
        Number count = (Number)queryForSingleValue(sql);
        return count.intValue();
    }
    public int querypagetotalbyprice(int min,int max)
    {
        String sql="SELECT COUNT(*) FROM t_book WHERE price BETWEEN ? and ?" ;
        Number count = (Number)queryForSingleValue(sql,min,max);
        return count.intValue();
    }


    public List<BOOK> querypageitemsbyprice(int min,int max,int begin, int pagesize) {
        String sql="select id,name,price,author,sales,stock,img_path from t_book  WHERE price BETWEEN ? and ? limit ?,?";
        return getmany(sql,BOOK.class,min,max,begin,pagesize);
    }
}
