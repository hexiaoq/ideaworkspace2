package prototype;

import java.util.Date;

/**
 * 测试深克隆,利用重写clone方法实现深克隆
 */

public class client2 {
    public static void main(String[] args) throws Exception {
        Date d=new Date(100);
        sheep2 s1=new sheep2("多利",d);
        System.out.println(s1.getName());
        System.out.println(s1.getDate());

        sheep2 s3=(sheep2)s1.clone();
        d.setTime(10000000l);//深克隆即使修改原型的对象，科隆的对象也不会发生改变
        System.out.println(s1.getName());
        System.out.println(s1.getDate());
        System.out.println(s3.getName());
        System.out.println(s3.getDate());



    }
}
