package Adapter;

/**
 * 客户端2(对象适配器）
 * （相当于只有usb接口的笔记本）
 */
public class client2 {
    public void test(target t) {
        t.linkkey();
    }

    public static void main(String[] args) {

        client2 c = new client2();
        adaptee key=new adaptee();
        adapter2 a=new adapter2(key);

        c.test(a);


    }
}
