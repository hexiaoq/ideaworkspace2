package caculator;

public class caculrebate extends  cacul{
    private double moneyrebate=1.0;

    public void setMoneyrebate(double moneyrebate) {
        this.moneyrebate = moneyrebate;
    }

    @Override
    public double getMoney(double money, int nums) {
        double money1 = super.getMoney(money, nums);
        return money1*moneyrebate;
    }
}
