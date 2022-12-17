package SimpleCalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SimpleCalcGUI {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JButton computeResultButton;
    private JLabel lblResult;

    public SimpleCalcGUI() {
        // Initialize and set up the layout of the GUI components
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        String[] operatorSymbols = {"+", "-", "*", "/"};
        comboBox1 = new JComboBox(operatorSymbols);
        computeResultButton = new JButton("Compute Result");
        lblResult = new JLabel("Result: ");

        panel1 = new JPanel();
        panel1.add(textField1);
        panel1.add(comboBox1);
        panel1.add(textField2);
        panel1.add(computeResultButton);
        panel1.add(lblResult);

        // Add an action listener to the computeResultButton
        computeResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the values from the text fields
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());

                // Get the chosen operator
                String operator = comboBox1.getSelectedItem().toString();

                double result = 0;

                // Perform the computation based on the chosen operator
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }

                // Display the result in the lblResult label
                lblResult.setText(String.valueOf(result));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SimpleCalcGUI");
        frame.setContentPane(new SimpleCalcGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
