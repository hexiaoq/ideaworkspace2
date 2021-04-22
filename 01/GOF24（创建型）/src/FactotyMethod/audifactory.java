package FactotyMethod;

public class audifactory implements factory {
    @Override
    public car produce() {
        return new audi();
    }
}
