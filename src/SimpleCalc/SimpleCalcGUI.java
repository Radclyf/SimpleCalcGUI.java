package SimpleCalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalcGUI {
    private JPanel panel1;
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JComboBox<String> cbOperations;
    private JButton btnCompute;
    private JTextField lblResult;

    public SimpleCalcGUI() {
        tfNumber1 = new JTextField();
        tfNumber2 = new JTextField();
        String[] operatorSymbol = {"+", "-", "*", "/"};
        cbOperations = new JComboBox<>(operatorSymbol);
        btnCompute = new JButton("Compute Result");
        lblResult = new JTextField("");

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(tfNumber1.getText());
                int y = Integer.parseInt(tfNumber2.getText());
                String operator = (String) cbOperations.getSelectedItem();
                int result = 0;

                switch (operator) {
                    case "+":
                        result = x + y;
                        break;
                    case "-":
                        result = x - y;
                        break;
                    case "*":
                        result = x * y;
                        break;
                    case "/":
                        result = x / y;
                        break;
                }

                lblResult.setText(String.format("", result));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setContentPane(new SimpleCalcGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
