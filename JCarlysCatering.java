/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W3HW;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Lisa
 */
public class JCarlysCatering extends JFrame implements ItemListener, ActionListener {

    int price = 0;
    int count = 0;
    final int PRICE_PER_GUEST = 35;
    String entreeMenu = "";
    String sideDishMenu = "";
    String dessertMenu = "";

    FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
    JLabel carlysHeaderLabel = new JLabel("***CARLY'S CATERING***");
    JLabel guestsLabel = new JLabel("Enter number of guests:");
    JLabel selectionEntreeLabel = new JLabel("Choose one entree:");
    JLabel selectionSideDishesLabel = new JLabel("Choose two sides:");
    JLabel selectionDessertLabel = new JLabel("Choose one desesrt:");
    JLabel totalPriceLabel = new JLabel();
    JLabel menuLabel = new JLabel();
    JButton submitButton = new JButton("Submit");
    JTextField guestsTextField = new JTextField(4);

    JCheckBox entree1 = new JCheckBox("Steak");
    JCheckBox entree2 = new JCheckBox("Chicken");
    JCheckBox entree3 = new JCheckBox("Fish");
    JCheckBox entree4 = new JCheckBox("Pasta");
    ButtonGroup entrees = new ButtonGroup();

    JCheckBox sideDish1 = new JCheckBox("Potatoes");
    JCheckBox sideDish2 = new JCheckBox("Beans");
    JCheckBox sideDish3 = new JCheckBox("Corn");
    JCheckBox sideDish4 = new JCheckBox("Salad");

    JCheckBox dessert1 = new JCheckBox("Cupcake");
    JCheckBox dessert2 = new JCheckBox("Sorbet");
    JCheckBox dessert3 = new JCheckBox("Brownie");
    ButtonGroup desserts = new ButtonGroup();

    public JCarlysCatering() {

        setTitle("Carlys Catering");
        setSize(410, 330);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
        carlysHeaderLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        guestsLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        guestsTextField.setPreferredSize(new Dimension(200, 30));
        submitButton.setPreferredSize(new Dimension(100, 30));
        totalPriceLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
        menuLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));

        entrees.add(entree1);
        entrees.add(entree2);
        entrees.add(entree3);
        entrees.add(entree4);
        add(sideDish1);
        add(sideDish2);
        add(sideDish3);
        add(sideDish4);
        desserts.add(dessert1);
        desserts.add(dessert2);
        desserts.add(dessert3);

        submitButton.addActionListener(this);
        entree1.addItemListener(this);
        entree2.addItemListener(this);
        entree3.addItemListener(this);
        entree4.addItemListener(this);
        sideDish1.addItemListener(this);
        sideDish2.addItemListener(this);
        sideDish3.addItemListener(this);
        sideDish4.addItemListener(this);
        dessert1.addItemListener(this);
        dessert2.addItemListener(this);
        dessert3.addItemListener(this);

        add(carlysHeaderLabel);
        add(guestsLabel);
        add(guestsTextField);
        add(submitButton);
        add(selectionEntreeLabel);
        add(entree1);
        add(entree2);
        add(entree3);
        add(entree4);
        add(selectionSideDishesLabel);
        add(sideDish1);
        add(sideDish2);
        add(sideDish3);
        add(sideDish4);
        add(selectionDessertLabel);
        add(dessert1);
        add(dessert2);
        add(dessert3);
        add(totalPriceLabel);
        add(menuLabel);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JCarlysCatering jCarlysCatering = new JCarlysCatering();
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        Object source = a.getSource();

        if (source == submitButton) {
            try {
                price = Integer.parseInt(guestsTextField.getText()) * PRICE_PER_GUEST;
            } catch (Exception b) {
                price = 0;
            }
            totalPriceLabel.setText("Total: $" + price + " ");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent c) {
        Object source = c.getSource();
        int select = c.getStateChange();

        if (source == entree1) {
            if (select == ItemEvent.SELECTED) {
                entreeMenu = "Steak" + ", ";
            }
        }
        if (source == entree2) {
            if (select == ItemEvent.SELECTED) {
                entreeMenu = "Chicken" + ", ";
            }
        }
        if (source == entree3) {
            if (select == ItemEvent.SELECTED) {
                entreeMenu = "Fish" + ", ";
            }
        }
        if (source == entree4) {
            if (select == ItemEvent.SELECTED) {
                entreeMenu = "Pasta" + ", ";
            }
        }

        if (source == sideDish1 || source == sideDish2 || source == sideDish3 || source == sideDish4) {
            if (select == ItemEvent.SELECTED) {
                count++;
            } else {
                count--;
            }
            sideDishMenu = "";
            if (count <= 2) {
                if (sideDish1.isSelected()) {
                    sideDishMenu += "Potatoes" + ", ";
                }
                if (sideDish2.isSelected()) {
                    sideDishMenu += "Beans" + ", ";
                }
                if (sideDish3.isSelected()) {
                    sideDishMenu += "Corn" + ", ";
                }
                if (sideDish4.isSelected()) {
                    sideDishMenu += "Salad" + ", ";
                }
            } else {
                sideDish1.setSelected(false);
                sideDish2.setSelected(false);
                sideDish3.setSelected(false);
                sideDish4.setSelected(false);
            }
        }

        if (source == dessert1) {
            if (select == ItemEvent.SELECTED) {
                dessertMenu = "Cupcake";
            }
        }
        if (source == dessert2) {
            if (select == ItemEvent.SELECTED) {
                dessertMenu = "Sorbet";
            }
        }
        if (source == dessert3) {
            if (select == ItemEvent.SELECTED) {
                dessertMenu = "Brownie";
            }
        }
        menuLabel.setText("Menu: " + entreeMenu + sideDishMenu + dessertMenu);
    }
}
