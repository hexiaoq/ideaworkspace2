package caculator;

public class caculreturn extends cacul {
    private double conditon=300;
    private double remoney=0;

    public void setConditon(double conditon) {
        this.conditon = conditon;
    }

    public void setRemoney(double remoney) {
        this.remoney = remoney;
    }

    public boolean meetconditon(double all)
    {
        if(all>=conditon)
        {
            return true;
        }
        else
            return false;
    }
    @Override
    public double getMoney(double money,int nums)
    {
        double money1 = super.getMoney(money, nums);

        if(meetconditon(money1))
        {
            return money1-remoney;
        }
        else
            return money1;
    }
}
