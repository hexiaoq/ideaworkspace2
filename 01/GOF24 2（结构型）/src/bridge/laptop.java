package bridge;

public class laptop extends computer {
    public laptop(bridge.brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        System.out.println("销售笔记本");
        super.sale();
    }
}
