import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class lisenter extends JFrame implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:

                System.out.println("turn down");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("turn left");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("turn right");
                break;
            case KeyEvent.VK_UP:
                System.out.println("turn up");
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {


    }


    public lisenter() throws HeadlessException {
        setTitle("测试键盘监听器");
        setSize(500, 500);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setLayout(null);


        setVisible(true);

    }



    public static void main(String[] args) {
        lisenter l=new lisenter();
        JPanel jPanel= new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(Color.black);
          g.fillRect(0, 0, 500, 500);
            }
        };
        l.setContentPane(jPanel);


        Label label=new Label("fight for future");
        label.setSize(200,200);
        label.setLocation(100,100);


        TextField f=new TextField("fighting",10);
        f.setBounds(300,200,200,200);
        f.setForeground(Color.red);
        f.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(f.getText());
            }
        });


        Button button=new Button();
        button.setBounds(150,150,50,100);

    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("cccc");
        }
    });
        l.getContentPane().add(button);
        l.getContentPane().add(label);
l.getContentPane().add(f);
       l.addKeyListener(l);



    }}
