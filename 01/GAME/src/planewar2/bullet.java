package planewar2;

import java.awt.*;

public class bullet extends gameobject {

    public bullet(int x, int y, int h, int w, int speed) {
        super(x, y, h, w, speed);
    }

    @Override
    public void drawself(Graphics g) {
        super.drawself(g);
     g.fillOval(x, y, 10, 10);
    }

    @Override
    public Rectangle getrec() {
        return super.getrec();
    }
}
