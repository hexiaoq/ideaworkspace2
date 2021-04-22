package singleton;

import java.lang.reflect.Constructor;

/**
 * 反射无法破解单例  singleton5
 */
public class client3 {
    public static void main(String[] args) throws Exception {
        singleton3 s1=singleton3.getInstance();
        singleton3 s2=singleton3.getInstance();
        System.out.println(s1);
        System.out.println(s2);

        Class clazz=Class.forName("singleton.singleton5");
        Constructor c=clazz.getDeclaredConstructor(null);
        c.setAccessible(true);
        singleton5 s3=(singleton5)c.newInstance();
        singleton5 s4=(singleton5)c.newInstance();
        System.out.println(s3);
        System.out.println(s4);




    }


}
