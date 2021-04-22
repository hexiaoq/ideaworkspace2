import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class webHandler extends DefaultHandler {
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
