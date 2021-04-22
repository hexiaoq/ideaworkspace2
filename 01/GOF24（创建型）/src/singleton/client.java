package singleton;

public class client {
    public static void main(String[] args) {
        singleton3 s1=singleton3.getInstance();
        singleton3 s2=singleton3.getInstance();
        System.out.println(s1);
        System.out.println(s2);

    }


}
