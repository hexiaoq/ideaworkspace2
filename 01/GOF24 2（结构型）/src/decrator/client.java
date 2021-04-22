package decrator;

public class client {
    public static void main(String[] args) {
        car car=new car();
        car.move();
        System.out.println("增加新功能"+"--------");
        supercar flycar=new flycar(car);
        flycar.move();
        System.out.println("增加新功能"+"--------");
        supercar sflycar=new swimcar(flycar);
        sflycar.move();

    }
}
