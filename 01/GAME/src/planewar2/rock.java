package planewar2;

import java.awt.*;

public class rock extends gameobject {
    public  rock(int h,int w,int s)
    {y=0;
        x=(int)(Math.random()*350);
        this.h=h;
        this.w=w;
        this.speed=s;
        System.out.println(x);
    }

    @Override
    public void drawself(Graphics g) {
        g.fillOval(x, y, w, h);
    }

    @Override
    public Rectangle getrec() {
        return super.getrec();
    }
}
