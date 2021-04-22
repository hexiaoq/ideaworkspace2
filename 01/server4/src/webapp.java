import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

public class webapp {


    /**
     *
     * @param 通过url返回其对应的servlet类
     * @return
     */
    public static Servlet getServletFromURL(String url) {
        try {  // 1. 获得解析工厂

            SAXParserFactory factory = SAXParserFactory.newInstance();

//2. 从解析工厂获得解析器：
            SAXParser parse = factory.newSAXParser();
            //3.编写处理器PHandler
            //4.解析
            webHandler handler = new webHandler();

            parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml"), handler);
            ArrayList<Entity> entities = handler.getEntitys();
            ArrayList<Mapping> mappings = handler.getMappings();
            lookfor look = new lookfor(handler.getEntitys(), handler.getMappings());
            if(null!=look.getclz("/" + url)){
            String classname = look.getclz("/" + url);
            System.out.println(look.getclz("/" + url));

                Class clz = Class.forName(classname);
                Servlet servlet = (Servlet) clz.getConstructor().newInstance();//反射作用的体现，知道一个类的名字得到这个类并返回
                return servlet;}
            else{
                System.out.println("错误url");
                return null;
            }

            }
        catch (Exception e) {
                e.printStackTrace();
                return null;
            }


        }
    }