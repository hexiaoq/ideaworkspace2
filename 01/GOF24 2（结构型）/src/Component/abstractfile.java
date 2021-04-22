package Component;
/**
 *组合模式  处理树形结构（ex；文件夹和文件）
 * text file是叶子节点 folder是容器节点 二者均实现abstactfile接口， folder增加 添加和删除叶子节点的方法
 *@何小强
 */

import java.util.ArrayList;
import java.util.List;

public interface abstractfile {
    public void killvirus();
}
class textfile implements  abstractfile{
String name;

    public textfile(String name) {
        this.name = name;
    }

    @Override
    public void killvirus() {
        System.out.println("查杀文本文件"+name+"病毒");
    }
}
class imagefile implements abstractfile{

    String name;

    public imagefile(String name) {
        this.name = name;
    }

    public void killvirus() {
        System.out.println("查杀图片文件"+name+"病毒");
    }
}
class videofile implements abstractfile{

    String name;

    public videofile(String name) {
        this.name = name;
    }

    public void killvirus() {
        System.out.println("查杀视频文件"+name+"病毒");
    }
}

class folder implements abstractfile{
    @Override
    public void killvirus() {
        System.out.println("查杀文件夹"+name+"病毒");
        for (abstractfile a:list
             ) {
            a.killvirus();

        }
    }
    String name;
    List<abstractfile> list;

    public folder(String name) {
        this.name = name;
        list=new ArrayList<abstractfile>();
    }
    public void add(abstractfile file)
    {if(file!=this)
        list.add(file);
    else System.out.println("文件夹不能自己添加自己");

    }
    public void remove(abstractfile file)
    {
        list.remove(file);
    }}