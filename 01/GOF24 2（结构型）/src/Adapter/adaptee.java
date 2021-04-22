package Adapter;

/**
 * 被适配类
 * （相当于例子中的无usb接口的键盘)
 */
public class adaptee {
    public void write(){
        System.out.println("键盘打字");
    }


}
