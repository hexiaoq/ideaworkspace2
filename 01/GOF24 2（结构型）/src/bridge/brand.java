package bridge;

public interface brand
{
    public void sale();

}
class lenovo implements brand{

    @Override
    public void sale() {
        System.out.println("销售lenovo牌电脑");
    }
}
class shenzhou implements brand{

    @Override
    public void sale() {
        System.out.println("销售神舟牌电脑");
    }
}