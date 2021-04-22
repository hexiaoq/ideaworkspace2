package FactotyMethod;

public class benzifactory implements factory {
    @Override
    public car produce() {
        return new benzi();
    }
}
