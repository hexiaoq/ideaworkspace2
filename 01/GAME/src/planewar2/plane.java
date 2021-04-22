package planewar2;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class plane extends gameobject  {
    static ArrayList<bullet> arr =new ArrayList<bullet>();
   static int x=150,y=500;

    int z=x+20;int q=y;

    public plane(Image im, int h, int w, int speed) {
        super(im, h, w, speed);
    }


    @Override
    public void drawself(Graphics g) {
        super.drawself(g);
        g.drawImage(im, x, y, null);





    }


    public void keyPressed(KeyEvent e) {switch (e.getKeyCode()) {
        case KeyEvent.VK_DOWN:
            if(y<510)


                y+=10;
            break;
        case KeyEvent.VK_LEFT:
            if(x>0)
                x-=10;

            break;
        case KeyEvent.VK_RIGHT:
            if(x<280)
                x+=10;
            break;
        case KeyEvent.VK_UP:
            if(y>0)
                y-=10;                        break;
        case KeyEvent.VK_S:
            arr.add(new bullet(x+20,y-10,10, 10,1));


            

                                 break;



    }

    }





}
