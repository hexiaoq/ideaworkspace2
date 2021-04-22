import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class first {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // 1. 获得解析工厂

        SAXParserFactory factory = SAXParserFactory.newInstance();

//2. 从解析工厂获得解析器：
        SAXParser parse = factory.newSAXParser();
        //3.编写处理器PHandler
        //4.解析
        PHandler handler = new PHandler();

        parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("p.xml"), handler);


    }
}
    class PHandler extends DefaultHandler{
        public void startDocument(){
            System.out.println("解析文档开始");

        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("解析开始"+qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("解析结束"+qName);

        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String contents=new String(ch,start,length);
            if (contents.length()>0)
            { System.out.println(contents);}

        }

        public void endDocument(){
            System.out.println("解析文档结束");

        }
    }

