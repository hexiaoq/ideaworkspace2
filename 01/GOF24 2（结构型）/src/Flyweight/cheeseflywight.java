package Flyweight;
/**
 *享元模式 当对象绝大多数为共有属性，只有少数为不同的属性，可用享元模式减少对象的产生
 *ex:棋盘上的黑棋除了位置都是一样的 这样只要定义一个黑棋对象就行了 位置属性通过享元模式添加
 *和装饰的区别，装饰针对类而且可以增加不同的属性，享元针对对象只能增加加一个相同的属性，
 *@何小强
 */

//公有属性类
public interface cheeseflywight {
    public void  display(location l);
    public void getcolor();

}
class Cheeseflyweight implements cheeseflywight{
public String color;

    public Cheeseflyweight(String color) {
        this.color = color;
    }

    //调用特定属性类的方法和属性
    @Override
    public void display(location l) {
        l.display();
    }

    @Override
    public void getcolor() {
        System.out.println(color);

    }
}