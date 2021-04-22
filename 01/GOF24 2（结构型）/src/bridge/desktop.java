package bridge;

public class desktop extends computer {

    public desktop(bridge.brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        System.out.println("销售台式机");
        super.sale();
    }
}
