package abstractfactory;

public class hcarfactory implements carfactory {
    @Override
    public void car() {
        System.out.println("高端汽车");
    }



    @Override
    public seat seat() {
        return new hseat();
    }

    @Override
    public tire tire() {
        return new htire();
    }
}
