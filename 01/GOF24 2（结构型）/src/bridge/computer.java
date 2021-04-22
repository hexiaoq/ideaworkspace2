package bridge;

public class computer {
    protected brand brand;

    public computer(bridge.brand brand) {
        this.brand = brand;
    }

    public  void  sale(){
        brand.sale();
    }

}
