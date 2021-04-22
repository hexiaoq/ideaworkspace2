package gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class average {

    public static void main(String[] args) {
        Computer computer = new Computer();
    }
}

class Computer extends JFrame implements DocumentListener {
    JTextArea text1, text2, text3;
    int count = 0;
    double sum = 0, aver = 0;

    Computer() {
        setLayout(new FlowLayout());
        text1 = new JTextArea(6, 43);
        text2 = new JTextArea(3, 38);
        text3 = new JTextArea(3, 38);
        add(new JScrollPane(text1));
        JLabel userLabel = new JLabel("和值");
        add(userLabel);
        add(new JScrollPane(text2));
        JLabel userLabel2 = new JLabel("平均值");
        add(userLabel2);
        add(new JScrollPane(text3));
        text2.setEditable(false);
        text3.setEditable(false);
        (text1.getDocument()).addDocumentListener(this);
        setSize(500, 300);
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    public void changedUpdate(DocumentEvent e) {
        String s = text1.getText();
        String[] a = s.split("[^0123456789.]+");


      sum=0;
      aver=0;
        for (int i = 0; i < a.length; i++) {
            try {
                sum = sum + Double.parseDouble(a[i]);
                count = i + 1;
            } catch (Exception ee) {
            }
        }
        aver = sum / count;
        text2.setText(null);
        text3.setText(null);
        text2.append("\n" + sum);
        text3.append("\n" + aver);
    }

    public void removeUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    public void insertUpdate(DocumentEvent e) {
        changedUpdate(e);
    }
}



