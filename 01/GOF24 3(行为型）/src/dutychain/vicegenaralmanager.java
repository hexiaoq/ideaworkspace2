package dutychain;
//增加一个副总经理的位置 不用改变源码 符合开闭原则

public class vicegenaralmanager implements leader {
    private String name;
    private leader l;

    public vicegenaralmanager(String name, leader l) {
        this.name = name;
        this.l = l;
    }

    @Override
    public void handreq(int leaveday) {
        if (leaveday <= 15) {
            System.out.println("vicegenaralmanager" + name + "处理");
        } else l.handreq(leaveday);
    }
}
