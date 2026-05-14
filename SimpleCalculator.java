import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {

    JTextField textField;

    double num1, num2, result;
    char operator;

    SimpleCalculator() {

        setTitle("Simple Calculator");
        setSize(300, 350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        textField = new JTextField();

        textField.setFont(new Font("Arial", Font.BOLD, 20));

        textField.setHorizontalAlignment(JTextField.RIGHT);

        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String buttons[] = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "0", "%", "=", "C"
        };

        for (String b : buttons) {

            JButton btn = new JButton(b);

            btn.setFont(new Font("Arial", Font.BOLD, 16));

            btn.addActionListener(this);

            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {

            textField.setText(textField.getText() + command);

        } else if (command.equals("C")) {

            textField.setText("");

        } else if (command.equals("=")) {

            num2 = Double.parseDouble(textField.getText());

            switch (operator) {

                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '%':
                    result = num1 % num2;
                    break;
            }

            textField.setText(String.valueOf(result));

        } else {

            num1 = Double.parseDouble(textField.getText());

            operator = command.charAt(0);

            textField.setText("");
        }
    }

    public static void main(String[] args) {

        new SimpleCalculator();
    }
}