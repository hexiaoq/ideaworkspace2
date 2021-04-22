package observer;

import java.util.Observable;
import java.util.Observer;

public class observer implements Observer {
    public int  mystate;
    @Override
    public void update(Observable o, Object arg) {
        mystate=((subject)o).getState();
    }

    public void getMystate() {
        System.out.println(mystate);
    }
}
