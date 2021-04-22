package caculator;

public class factory {
    public static cacul getcacul(String type)
    {
        cacul caculator=null;
        switch (type)
        {
            case "normal":return new caculnormal();
            case "打折": return new caculrebate();
            case "满减": return new caculreturn();
            default:return new caculnormal();

        }
    }
}
