package dutychain;

public class client {
    public static void main(String[] args) {
        leavereq emp=new leavereq("员工甲",12);
        leader l=new director("王主管",new manager("张经理",new vicegenaralmanager("李四",new genaralmanager("何小强"))));
        emp.sentreq(l);

    }


}
