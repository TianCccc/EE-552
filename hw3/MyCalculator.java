package hw3;

/**
 * @author Tiancheng Xu
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculator extends JFrame{
    private final String names[] = {
        "7", "8", "9", "+",
        "4", "5", "6", "-",
        "1", "2", "3", "*",
        "0", ".", "=", "÷"};
    private JTextField textField;
    private int select = 0;
    private double temp = 0.0;
    private double number;
    MyCalculator () {
        textField = new JTextField();
        GridLayout gridLayout = new GridLayout(4, 4);
        JPanel panel = new JPanel();
        panel.setLayout(gridLayout);
        JButton[] buttons = new JButton[names.length];
        for (int i = 0; i < names.length; i++) {
            buttons[i] = new JButton(names[i]);
            panel.add(buttons[i]);
        }

        // num action
        class NumButtonHandler implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                JButton object = (JButton)event.getSource();
                char jButtonName = object.getText().charAt(0);
                switch (jButtonName) {
                    default:
                        setTextField(jButtonName);
                        break;
                }
            }
            void setTextField(char jButtonName) {
                textField.setText(textField.getText()+String.valueOf(jButtonName));
            }
        }
         
        // operator action
        class opeButtonHandler implements  ActionListener{
            public void actionPerformed(ActionEvent event) {
                String command = event.getActionCommand();
                if (command.equals("+")) {
                    temp = Double.parseDouble(textField.getText());
                    textField.setText("");
                    select = 1;
                }
                if (command.equals("-")) {
                    temp = Double.parseDouble(textField.getText());
                    textField.setText("");
                    select = 2;
                }
                if (command.equals("*")) {
                    temp = Double.parseDouble(textField.getText());
                    textField.setText("");
                    select = 3;
                }
                if (command.equals("÷")) {
                    temp = Double.parseDouble(textField.getText());
                    textField.setText("");
                    select = 4;
                }
                // calculate
                if (command.equals("=")) {
                    switch (select) {
                        case 1:
                            number = Double.parseDouble(textField.getText());
                            textField.setText((temp+number)+"");
                            break;
                        case 2:
                            number = Double.parseDouble(textField.getText());
                            textField.setText((temp-number)+"");
                            break;
                        case 3:
                            number = Double.parseDouble(textField.getText());
                            textField.setText((temp*number)+"");
                            break;
                        case 4:
                            number = Double.parseDouble(textField.getText());
                            textField.setText((temp/number)+"");
                            break;
                    }
                }
            }
        }

        NumButtonHandler numButtonHandler = new NumButtonHandler();
        for (int i = 0; i < names.length; i++) {
            if(i == 3 || i == 7 || i == 11  || i == 14 || i == 15)
                buttons[i].addActionListener(new opeButtonHandler());
            else
                buttons[i].addActionListener(numButtonHandler);
        }

        // text part as top
        getContentPane().add(textField, BorderLayout.NORTH);
        // panel part as center
        getContentPane().add(panel, BorderLayout.CENTER);

        this.setTitle("Caculator");
        this.setBounds(80,80,300,200);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyCalculator();
    }
}
