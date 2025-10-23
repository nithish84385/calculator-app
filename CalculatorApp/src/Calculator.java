import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField tf;
    String operator;
    double num1, num2;

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tf = new JTextField();
        tf.setEditable(false);
        tf.setFont(new Font("Arial", Font.BOLD, 24));
        add(tf, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789.".contains(command)) {
            tf.setText(tf.getText() + command);
        } else if ("/-*+".contains(command)) {
            num1 = Double.parseDouble(tf.getText());
            operator = command;
            tf.setText("");
        } else if ("=".equals(command)) {
            num2 = Double.parseDouble(tf.getText());
            switch (operator) {
                case "+": tf.setText("" + (num1 + num2)); break;
                case "-": tf.setText("" + (num1 - num2)); break;
                case "*": tf.setText("" + (num1 * num2)); break;
                case "/": tf.setText("" + (num1 / num2)); break;
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
