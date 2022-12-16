package SimpleCalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalcGUI {
    private JPanel panel1;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton computeResultButton;

    public SimpleCalcGUI() {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        computeResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double operand = Double.parseDouble(textField1.getText());
                String operator = (String) comboBox1.getSelectedItem();
                double result = 0;

                switch(operator) {
                    case "+":
                        result = operand + operand;
                        break;
                    case "-":
                        result = operand - operand;
                        break;
                    case "*":
                        result = operand * operand;
                        break;
                    case "/":
                        result = operand / operand;
                        break;
                }

                JOptionPane.showMessageDialog(null, "Result: " + result);
            }
        });
    }

    public static void main(String[] args) {
        new SimpleCalcGUI();
    }
}
