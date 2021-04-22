package planewar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class plane extends JFrame {
    public plane() throws HeadlessException {
        setTitle("planewar");
        setSize(350,600);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);

        setVisible(true);
    }
static int x=150,y=500,z=y+10; static boolean lauch=false;
    public static void main(String[] args) {
        ImageIcon i=new ImageIcon("GAME\\src\\plane.png");
        plane p=new plane();
        System.out.println(i.getIconHeight()+"---->"+i.getIconWidth());


        JPanel j=new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(Color.black);
                g.fillRect(0, 0, 350, 600);
                g.drawImage(i.getImage(), x, y, null);
                while(lauch){
                    g.fillOval(x+10,z , 10, 10);
                }

                this.repaint();
            }
        };
        p.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
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



                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        p.setContentPane(j);
        p.setVisible(true);
    }
}
