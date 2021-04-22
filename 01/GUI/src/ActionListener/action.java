package ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class action extends JFrame implements ActionListener {
    static JLabel s1=new JLabel("输入的整数为");
    static JLabel s2=new JLabel("输入的浮点数为");
    static JLabel s3=new JLabel("0");
    static JLabel s4=new JLabel("0.0");

    static JTextField j1=new JTextField("0",10);
    static JTextField j2=new JTextField("0.0",10);


    @Override
    public void actionPerformed(ActionEvent e) {
        s3.setText("整数为"+j1.getText());
        s4.setText("浮点数为"+j2.getText());




    }

    public static void main(String[] args) {
        action frame=new action();
        frame.setTitle("动作监听器");
        frame.setSize(200,160);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        j1.addActionListener(frame);
        j2.addActionListener(frame);

        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(s1);
        frame.getContentPane().add(j1);
        frame.getContentPane().add(s2);

        frame.getContentPane().add(j2);
        frame.getContentPane().add(s3);
        frame.getContentPane().add(s4);
        frame.setVisible(true);
    }
}
