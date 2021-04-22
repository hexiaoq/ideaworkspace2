package FactotyMethod;

public class bydfactory implements factory {

    @Override
    public car produce() {
        return new byd();
    }
}
