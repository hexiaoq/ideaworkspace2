package com.hxq;

import com.hxq.bean.bean;
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

public class test2 {

    private InputStream in;
    private SqlSessionFactory factory;
   private SqlSession session;
   private userdao dao;
   @Before
   public void init() throws IOException {
       in=Resources.getResourceAsStream("sqlmapconfig.xml");
       factory=new SqlSessionFactoryBuilder().build(in);
       session=factory.openSession();
       dao=session.getMapper(userdao.class);
   }
   @After
   public void close() throws Exception{
       session.commit();
       session.close();
       in.close();
   }
   @Test
    public void findall() throws IOException {
       test2 t=new test2();
       t.init();
       List<bean> users=t.dao.findall();
       for (bean user : users) {
           System.out.println(user);
           System.out.println(user.getCustomer());
       }

   }
    @Test
    public void insert() throws IOException {
        test2 t=new test2();
        t.init();
        bean user=new bean(null,"何小强","156437734","新余市","13979021036");
        t.dao.insert(user);
        t.session.commit();
        }

    }

