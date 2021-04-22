package simpleFactory;

/**
 * 简单工厂模式，创建对象的工作交给工厂，无论创建多么麻烦，外界只需要执行调用工厂这一简单的操作
 * 复杂的工作交给工厂，这样也能对代码进行很好的封装
 * 弊端 不符合开闭原则
 * @何小强
 */
public class factory
{
    public static car factory(String name){
        if(name.equals("奥迪"))
            return new audi();
        else if(name.equals("比亚迪"))
            return new byd();
        else
            return  null;

    }
}
