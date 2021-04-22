package FactotyMethod;
/*
工厂方法模式，将工厂编写为接口，具体对象生产作为实现类，
这样如果车辆品牌需要增加，不需要更改工厂代码，只需要增加一个实现类，符合封闭性原则，更好扩展
弊端：代码量太大 工作一般使用简单工厂模式
 */
public interface factory {
    public  car produce() ;
}
