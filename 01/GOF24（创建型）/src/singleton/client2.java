package singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 利用反射和反序列化破解单例
 */
public class client2 {
    public static void main(String[] args) throws Exception {
        singleton3 s1=singleton3.getInstance();
        singleton3 s2=singleton3.getInstance();
        System.out.println(s1);
        System.out.println(s2);

        Class clazz=Class.forName("singleton.singleton3");
        Constructor c=clazz.getDeclaredConstructor(null);
        c.setAccessible(true);
        singleton3 s3=(singleton3)c.newInstance();
        singleton3 s4=(singleton3)c.newInstance();
        System.out.println(s3);
        System.out.println(s4);

        File f=new File("a.txt");
        ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("f"));
        os.writeObject(s1);
        os.close();
        //序列化

        ObjectInputStream is=new ObjectInputStream(new FileInputStream("f"));
        singleton3 s5=(singleton3)is.readObject();
        is.close();//反序列化，也可以破解单例模式

        System.out.println(s5);




    }


}
