package FoodOrdering;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderGUI extends JFrame{
    private JPanel panel1;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;

    static class OrderSumNoneZero extends Exception {
    }
    static class SelectDiscount extends Exception {
    }

    public FoodOrderGUI() {
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double totalPrice = 0;
                int count = 0;

                try{
                    if (cPizza.isSelected()) {
                        totalPrice += 100;
                    }
                    if (cBurger.isSelected()){
                        totalPrice += 80;
                    }
                    if (cFries.isSelected()){
                        totalPrice += 65;
                    }
                    if (cSoftDrinks.isSelected()){
                        totalPrice += 55;
                    }
                    if (cTea.isSelected()){
                        totalPrice += 50;
                    }
                    if (cSundae.isSelected()){
                        totalPrice += 40;
                    }
                    if(totalPrice == 0){
                        throw new OrderSumNoneZero();
                    }
                    if (rbNone.isSelected()){
                        count++;
                    } else if (rb5.isSelected()) {
                        totalPrice = totalPrice - (totalPrice * 0.05);
                        count++;
                    } else if (rb10.isSelected()) {
                        totalPrice = totalPrice - (totalPrice * 0.10);
                        count++;
                    } else if (rb15.isSelected()) {
                        totalPrice = totalPrice - (totalPrice * 0.15);
                        count++;
                    }
                    if (count == 0) {
                        throw new SelectDiscount();
                    }
                } catch (OrderSumNoneZero i) {
                    JOptionPane.showMessageDialog(btnOrder, "Please select Discount");
                    return;
                } catch (SelectDiscount i) {
                    JOptionPane.showMessageDialog(btnOrder, "Please select Discount");
                    return;
                }

                String str = Double.toString(totalPrice);

                JOptionPane.showMessageDialog(btnOrder, "The total price is Php " + str);
            }
        });
    }

    public static void main(String[] args) {
        FoodOrderGUI app = new FoodOrderGUI();
        app.setContentPane(app.panel1);
        app.setTitle("Food Ordering System");
        app.setSize(700, 700);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
