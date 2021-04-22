import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

public class second {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // 1. 获得解析工厂

        SAXParserFactory factory = SAXParserFactory.newInstance();

//2. 从解析工厂获得解析器：
        SAXParser parse = factory.newSAXParser();
        //3.编写处理器PHandler
        //4.解析
        PHandler2 handler = new PHandler2();

        parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("p2.xml"), handler);
        ArrayList<Person> persons=handler.getPersons();
        System.out.println("输出信息");
        for (Person p:persons) {
            if(null!=p) {
                System.out.println(p.getName()+"---->"+p.getAge());

            }
        }


    }
}

class PHandler2 extends DefaultHandler{
    ArrayList<Person> persons=new ArrayList<Person>();
   private String tag;
   Person person;
    public void startDocument(){
        System.out.println("解析文档开始");



    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
if(qName.equals("person"))
    person=new Person();
        if(null!=qName)
            tag=qName;

    }


    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents=new String(ch,start,length);
        if(null!=tag){
        if(tag.equals("name"))
        {
            person.setName(contents);
        }
        else if(tag.equals("age")) {
            person.setAge(contents);
        }}
    }
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("person"))
            persons.add(person);
        tag=null;//空格也会被解析 而空格并没有qName,所以tag不变，空格的内容会覆盖之前的name

    }
    public void endDocument(){
        System.out.println("解析文档结束");

    }

    public ArrayList<Person> getPersons() {
        return persons;
    }
}

