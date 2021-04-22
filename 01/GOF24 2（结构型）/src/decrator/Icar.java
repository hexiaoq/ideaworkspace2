package decrator;
/**
 *装饰模式
 * 通俗来讲,AB两个实现了同一接口c,且a中有c的引用,则b和b的子类如果讲 c的引用具体为a后,就可以随意调用a的接口方法
 * 这样b的子类既可以增加新方法,又可以拥有任何实现了c接口类中的接口方法
 * 装饰模式只需要实现基本功能类，功能组合可以通过装饰添加到一个具有某种功能的对象上，避免类膨胀，增加灵活性
 *@何小强
 */
//抽象构件（被装饰）角色
public interface Icar {
    public void move();
}

//具体构件角色
class  car implements Icar{

    @Override
    public void move() {
        System.out.println("陆地驾驶");
    }
}
//抽象装饰角色
class supercar implements Icar{
    //这里用用Icar不用car是因为 supercar也实现了Icar接口，
    // 到时候参数也可以传supercar的子类，完成装饰角色也可以被进一步装饰
    //（原理：当接口对象作为参数，且调用的是接口内的抽象方法时，所以实现此接口的类对象都可以作为参数。）
    protected Icar car;

    public supercar(decrator.Icar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}
