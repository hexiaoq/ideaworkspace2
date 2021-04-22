package bridge;
/**
 *桥接模式
 * 避免有品牌和电脑品种两个影响该类的因素
 * 如果要增加新的品牌只需要增加一个实现brand接口的类  新的电脑品种则新增一个继承computer的类即可
 *@何小强
 */

public class client {
    public static void main(String[] args) {
        brand lenovo=new lenovo();
        computer lenovolaptop=new laptop(lenovo);
        lenovolaptop.sale();
    }
}
