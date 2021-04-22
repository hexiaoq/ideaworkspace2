package abstractfactory;

public class lowcarfactory implements carfactory {
    @Override
    public void car() {
        System.out.println("低端汽车");
    }



    @Override
    public seat seat() {
        return new lowseat();
    }

    @Override
    public tire tire() {
        return new lowhire();
    }
}
