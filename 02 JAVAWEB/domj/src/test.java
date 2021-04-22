import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/*
*dom4j jar包  进行xml解析
*@ 何小强
*/
public class test {
    public static void main(String[] args) {
        SAXReader reader=new SAXReader();
        try {
            Document doc = reader.read("F:\\idea workspace\\02 JAVAWEB\\domj\\src\\book.xml");
            Element rootElement = doc.getRootElement();
            List<Element> book = rootElement.elements("book");
            for (Element s:book
                 ) {
                String author = s.elementText("author");
                String name = s.elementText("name");
                String sn = s.elementText("sn");
                String price = s.elementText("price");

                System.out.println(new book(author,name,sn,price));



            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}

