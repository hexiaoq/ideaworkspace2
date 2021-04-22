package planewar2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class game extends JFrame {
    Timer timer=new Timer();
    Timer t=new Timer();
    ArrayList<rock> ro = new ArrayList<rock>();
    ImageIcon i = new ImageIcon("GAME\\src\\plane.png");
    ImageIcon back = new ImageIcon("GAME\\src\\飞机背景.jpg");
    plane p = new plane(i.getImage(), 50, 50, 2);

    public game() throws HeadlessException {
        setTitle("星球大战");
        setSize(350, 600);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    class KEYMonitor extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }


    }

    public void paint(Graphics g) {

        g.drawImage(back.getImage(), 0, 0, null);
        p.drawself(g);
        for (bullet b : p.arr

        ) {
            b.y -= 10;
            b.drawself(g);
        }
        ;
        for (rock r : ro

        ) {r.y+=10;
        r.drawself(g);

        }


    }


    public void lauchgame() {
        addKeyListener(new KEYMonitor());
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() { while(ro.size()<10)

     ro.add(  new rock(30, 30, 1));

                //移除容器中的数组用迭代器的方法,用容器自己的方法和foreach语句这里会报错
                Iterator<rock> iterator=ro.iterator();
                while(iterator.hasNext()) {
                    rock r = iterator.next();
                    if (r.y > 600)
                        iterator.remove();
                    //将超出小框的小球对象重置null,并强制启动java回收机制,防止内存爆炸
                    r = null;
                    System.gc();

                }
            }
        }, 0, 1000);
        thread x = new thread();
        x.start();
    }

    class thread extends Thread {
        public void run() {
            while (true) {


                repaint();


                try {
                   thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        game g = new game();
        g.lauchgame();


    }
}
