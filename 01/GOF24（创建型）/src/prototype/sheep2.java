package prototype;

import java.util.Date;

/**
 * 重写clone方法实现深克隆
 */
public class sheep2 implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //重写clone方法实现深克隆
        Object obj=super.clone();
        sheep2 s=(sheep2) obj;
        s.date=(Date)this.date.clone();
        return obj;
    }

    String name;
    Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public sheep2(String name, Date date) {
        this.name = name;
        this.date = date;
    }
}
