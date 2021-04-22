package Adapter;

/**
 * 适配器
 * （相当于usb转接器）
 * 对象适配器，通过把被适配对象作为自己的成员属性，实现适配
 */
public class adapter2  implements target {
   public adaptee ad;

    public adapter2(adaptee ad) {
        this.ad = ad;
    }

    @Override
    public void linkkey() {
        ad.write();
    }
}
