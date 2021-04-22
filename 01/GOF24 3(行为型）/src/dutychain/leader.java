package dutychain;
/**
 *责任链模式，当一个问题分不同情况需要多个相似的对象处理时，使用
 * 避免了庞大if esle结构  增加新的处理对象时，也可以直接增加新类，不必修改源码，ex:vicegenaralmanager类，符合简单开闭原则
 *@何小强
 */

public interface leader {
    public void handreq(int leaveday);



}
class director implements leader{
private String name;
private leader l;

    public director(String name, leader l) {
        this.name = name;
        this.l = l;
    }

    @Override
    public void handreq(int leaveday) {
        if(leaveday<=3)
        {
            System.out.println("director"+name+"处理");
        }
        else l.handreq(leaveday);
    }


}class manager implements leader{
private String name;
private leader l;

    public manager(String name, leader l) {
        this.name = name;
        this.l = l;
    }

    @Override
    public void handreq(int leaveday) {
        if(leaveday<=10)
        {
            System.out.println("manager"+name+"处理");
        }
        else l.handreq(leaveday);
    }


}class genaralmanager implements leader{
private String name;


    public genaralmanager(String name) {
        this.name = name;

    }

    @Override
    public void handreq(int leaveday) {
        if(leaveday<20)
        {
            System.out.println("generalmanager"+name+"处理");
        }
        else System.out.println("开除此员工");
    }


}
