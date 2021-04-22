package prototype;

import java.io.*;
import java.util.Date;

/**
 * 利用反序列化实现深克隆
 */

public class client3 {
    public static void main(String[] args) throws Exception {
        Date d=new Date(100);
        sheep s1=new sheep("多利",d);
        System.out.println(s1.getName());
        System.out.println(s1.getDate());

        //反序列化方法
        File f=new File("f.txt");
        ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("f"));
        os.writeObject(s1);
        os.close();

        ObjectInputStream is=new ObjectInputStream(new FileInputStream("f"));
        sheep s2=(sheep)is.readObject();
        is.close();



        d.setTime(10000000l);
        System.out.println(s1.getName());
        System.out.println(s1.getDate());
        System.out.println(s2.getName());
        System.out.println(s2.getDate());



    }
}
