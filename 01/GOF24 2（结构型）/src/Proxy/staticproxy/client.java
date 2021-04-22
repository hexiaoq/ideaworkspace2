package Proxy.staticproxy;

public class client {
    public static void main(String[] args) {
        realstar ronadol = new realstar();
        proxy me = new proxy(ronadol);
        me.conference();
        me.conference();
        me.collectmoney();
        me.football();

    }
}
