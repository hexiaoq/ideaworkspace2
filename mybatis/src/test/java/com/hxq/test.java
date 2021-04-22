package com.hxq;

import com.hxq.bean.bean;
import com.hxq.dao.userdao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {
        InputStream in= Resources.getResourceAsStream("sqlmapconfig.xml");

        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);

        SqlSession session=factory.openSession();

        userdao uesrdao=session.getMapper(userdao.class);

        List<bean> users=uesrdao.findall();
        for(bean user:users)

        {
            System.out.println(user);

        }
        session.close();
        in.close();


    }
}
