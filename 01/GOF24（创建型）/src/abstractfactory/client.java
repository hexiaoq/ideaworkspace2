package abstractfactory;

/**
 * 当一个产品需要多个构件组成时，可以使用此方法，仙生产各个构件再在carfactory中组合
 */
public class client {
    public static void main(String[] args) {
        carfactory c1=new hcarfactory();
        c1.car();
        seat seat=c1.seat();
        tire  tire=c1.tire();
        seat.seat();
        tire.tire();



    }
}
