package Component;

public class client {
    public static void main(String[] args) {
        abstractfile f2,f3,f4,f6,f7,f8;
        f2=new textfile("我的书单");
        f3=new videofile("我的电影");
        f4=new imagefile("我的图片");
        f6=new imagefile("私密图片");
        f7=new videofile("岛国片");
        f8=new textfile("颜色小说");
        folder f1=new folder("我的文件夹");
folder f5=new folder("加密文件夹");
f5.add(f6);
f5.add(f7);
f5.add(f8);
        f1.add(f2);
        f1.add(f3);
        f1.add(f4);
        f1.add(f5);

        f1.killvirus();


    }
}
