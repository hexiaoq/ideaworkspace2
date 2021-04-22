package planewar2;

import java.awt.*;

public class gameobject
{
    Image im;

    public gameobject(int x, int y, int h, int w, int speed) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.speed = speed;
    }

    int x,y;

    public gameobject(Image im, int h, int w, int speed) {
        this.im = im;
        this.h = h;
        this.w = w;
        this.speed = speed;
    }

    int h,w;
     int speed;

    public gameobject(Image im,  int h, int w) {
        this.im = im;

        this.h = h;
        this.w = w;
    }

    public gameobject() {
    }


    public  void drawself(Graphics g)
    {
        g.drawImage(im, x, y,null );
    }
    public  Rectangle getrec(){
        return new Rectangle();
    }
}
