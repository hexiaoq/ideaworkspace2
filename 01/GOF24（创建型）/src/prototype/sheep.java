package prototype;

import java.io.Serializable;
import java.util.Date;

public class sheep implements Serializable , Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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

    public sheep(String name, Date date) {
        this.name = name;
        this.date = date;
    }
}
