package dutychain;

public class leavereq  {
    private  String name;

    public leavereq(String name, int leaveday) {
        this.name = name;
        this.leaveday = leaveday;
    }

    public int leaveday;
    public void sentreq(leader l){
        System.out.println("员工"+name+"发出请假请求,天数为"+leaveday);
        l.handreq(leaveday);
    }
}
