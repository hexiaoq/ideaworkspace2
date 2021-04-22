package caculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("请输入活动类型:");
        Scanner s=new Scanner(System.in);
        String s1 = s.nextLine();
        cacul getcacul = factory.getcacul(s1);
        System.out.print("请输入产品单价:");
        double price=s.nextDouble();
        System.out.print("请输入商品数量:");
        int num=s.nextInt();
        double money = getcacul.getMoney(price, num);
        System.out.println("商品总价是:"+money);

    }
}
