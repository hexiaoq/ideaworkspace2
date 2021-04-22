package Flyweight;

public class client
{
    public static void main(String[] args) {
        Cheeseflyweight cheese1=flyweightfactory.produce("black");
        Cheeseflyweight cheese2=flyweightfactory.produce("black");
        System.out.println(cheese1);
        System.out.println(cheese2);
        cheese1.display(new location(1,3));
        cheese2.display(new location(3,5));

    }
}
