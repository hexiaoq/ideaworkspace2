package Adapter;

/**
 * 客户端
 * （相当于只有usb接口的笔记本）
 */
public class client {
    public void test(target t) {
        t.linkkey();
    }

    public static void main(String[] args) {

        client c = new client();
        adapter a=new adapter();

        c.test(a);


    }
}
