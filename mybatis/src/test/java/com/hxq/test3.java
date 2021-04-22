package com.hxq;

import com.hxq.bean.bean;
import com.hxq.bean.cus;
import com.hxq.dao.cusdao;
import com.hxq.dao.userdao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test3 {

    private InputStream in;
    private SqlSessionFactory factory;
   private SqlSession session;
   private cusdao dao;
   @Before
   public void init() throws IOException {
       in=Resources.getResourceAsStream("sqlmapconfig.xml");
       factory=new SqlSessionFactoryBuilder().build(in);
       session=factory.openSession();
       dao=session.getMapper(cusdao.class);
   }
   @After
   public void close() throws Exception{
       session.commit();
       session.close();
       in.close();
   }
   @Test
    public void findall() throws IOException {
       test3 t = new test3();
       t.init();
       List<cus> users = t.dao.findall();
       for (cus user : users) {
           System.out.println(user);
       }

   }
   @Test
    public void findbyid()
   {
       cus findbyid = dao.findbyid(2);
       System.out.println(findbyid);

   }

}


