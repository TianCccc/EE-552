package Quiz5A;

import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class q1 extends JFrame{
    private int count = 0;
    private String s = "";
    public q1() {
        JButton b = new JButton("click");
        JTextField f = new JTextField();
        f.setEnabled(false);

        add(b, BorderLayout.SOUTH);
        add(f, BorderLayout.NORTH);
        this.setSize(1000, 1000);
        this.setTitle("Q1");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                count += 1;
                for (int i = 0; i < count; i++) {
                    s += "hello!";
                    f.setText(s);
                }
            }
        });

        
    }

    public static void main (String[] args) {
        new q1();
    }
}
