package Proxy.staticproxy;

/**
 * 代理人模式 静态代理
 */

public class proxy implements star {
    private star ronaldo;

    public proxy(star ronaldo) {
        this.ronaldo = ronaldo;
    }

    @Override
    public void football() {
        ronaldo.football();
    }





    @Override
    public void collectmoney() {
        System.out.println("帮C罗收钱");
    }

    @Override
    public void conference() {
        System.out.println("帮C罗签合同");
    }

    @Override
    public void plandate() {
        System.out.println("帮C罗安排时间");
    }
}
