package webxml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.Scanner;

public class third {
    public static void main(String[] args) throws Exception {
        // 1. 获得解析工厂

        SAXParserFactory factory = SAXParserFactory.newInstance();

//2. 从解析工厂获得解析器：
        SAXParser parse = factory.newSAXParser();
        //3.编写处理器PHandler
        //4.解析
        webHandler handler = new webHandler();

        parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml"), handler);
        ArrayList<Entity> entities=handler.getEntitys();
        ArrayList<Mapping> mappings=handler.getMappings();
        lookfor look=new lookfor(handler.getEntitys(),handler.getMappings());
        System.out.println("输出信息");
        for (Entity e:entities
             ) {
            System.out.println(e.getName()+"---->"+e.getCls());
        }
        for (Mapping m:mappings
             ) {
            System.out.println(m.getName()+"----->"+m.getPattern());

        }
        Scanner op=new Scanner(System.in);
        while (true) {
            String i = op.nextLine();
            String clz=look.getclz(i);
            System.out.println(look.getclz(i));
            Class c=Class.forName(clz);
            Servlet cl=(Servlet)c.getConstructor().newInstance();
            System.out.println(cl);
            cl.service();
        }

    }
}

class webHandler extends DefaultHandler{
    ArrayList<Entity> entitys=new ArrayList<Entity>();
    ArrayList<Mapping> mappings=new ArrayList<Mapping>();
   private String tag;
   private boolean ismapping;
   Entity entity;
   Mapping mapping;
    public void startDocument(){
        System.out.println("解析文档开始");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
if(qName.equals("servlet"))
{ entity=new Entity();
ismapping=false;}
else if(qName.equals("servlet-mapping"))
{ mapping=new Mapping();
ismapping=true;}
        if(null!=qName)
            tag=qName;

    }


    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents=new String(ch,start,length);
        if(null!=tag){
            if(!ismapping){
        if(tag.equals("servlet-name"))
        {
            entity.setName(contents);
        }
        else if(tag.equals("servlet-class")) {
            entity.setCls(contents);
        }}
            else if(ismapping)
            {if(tag.equals("servlet-name"))
            {
                mapping.setName(contents);
            }
            else if(tag.equals("url-pattern")) {
                mapping.setPattern(contents);
            }}

            }
        }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("servlet"))
            entitys.add(entity);
        else if(qName.equals("servlet-mapping"))
            mappings.add(mapping);
        if(null!=qName)
        tag=null;//空格也会被解析 而空格并没有qName,所以tag不变，空格的内容会覆盖之前的name

    }
    public void endDocument(){
        System.out.println("解析文档结束");

    }

    public ArrayList<Entity> getEntitys() {
        return entitys;
    }

    public ArrayList<Mapping> getMappings() {
        return mappings;
    }
}

