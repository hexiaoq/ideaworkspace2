package Adapter;

/**
 * 适配器:通俗来讲就是我没有你的引用,但我可以让一个类,实现我的引用接口又继承你,
 * 这样我可以通过这个类所实现的接口方法中调用你的方法,以达到调用你的效果
 * （相当于usb转接器）
 * 类适配器，通过继承实现适配器
 */
public class adapter extends adaptee implements target {
    @Override
    public void linkkey() {
        super.write();
    }
}
