package prototype;

import java.util.Date;

/**
 * 原型模式（深浅克隆）：如果new的过程比较繁琐耗时，则可以使用原型模式节省时间
 * 浅克隆，及浅克隆的问题
 */

public class client {
    public static void main(String[] args) throws Exception {
        Date d=new Date(100);
        sheep s1=new sheep("多利",d);
        System.out.println(s1.getName());
        System.out.println(s1.getDate());

        sheep s2=(sheep)s1.clone();
        System.out.println(s2.getName());
        System.out.println(s2.getDate());

        sheep s3=(sheep)s1.clone();
        d.setTime(10000000l);//修改s1的对象data，则之前拷贝完的s3的data对象也会发生改变，
        // 这是因为浅克隆s3的对象data并没有复制和s1指向的是同一个
        System.out.println(s1.getName());
        System.out.println(s1.getDate());
        System.out.println(s3.getName());
        System.out.println(s3.getDate());



    }
}
