/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W3HW;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author Lisa
 */
public class JVacationRental extends JFrame implements ItemListener {

    final int PARKSIDE_PRICE = 600;
    final int POOLSIDE_PRICE = 750;
    final int LAKESIDE_PRICE = 825;
    final int ONE_BED_PRICE = 0;
    final int TWO_BED_PRICE = 75;
    final int THREE_BED_PRICE = 150;
    final int MEAL_PRICE = 200;
    int cabinSelected;
    int bedSelected;
    int mealSelected;
    int totalPrice;

    JLabel titleLabel = new JLabel("Please choose from the following...");
    JLabel totalPriceLabel = new JLabel();

    JCheckBox parkside = new JCheckBox("Parkside Cabin $" + PARKSIDE_PRICE);
    JCheckBox poolside = new JCheckBox("Lakeside Cabin $" + POOLSIDE_PRICE);
    JCheckBox lakeside = new JCheckBox("Poolside Cabin $" + LAKESIDE_PRICE);
    ButtonGroup cabins = new ButtonGroup();

    JCheckBox oneBed = new JCheckBox("One Bedroom + $" + ONE_BED_PRICE);
    JCheckBox twoBed = new JCheckBox("Two Bedroom + $" + TWO_BED_PRICE);
    JCheckBox threeBed = new JCheckBox("Three Bedroom + $" + THREE_BED_PRICE);
    ButtonGroup beds = new ButtonGroup();

    JCheckBox meals = new JCheckBox("Meals included + $" + MEAL_PRICE);

    public JVacationRental() {
        setTitle("Lambert Vacation Rentals");
        setSize(250, 330);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);

        cabins.add(parkside);
        cabins.add(poolside);
        cabins.add(lakeside);
        beds.add(oneBed);
        beds.add(twoBed);
        beds.add(threeBed);

        parkside.addItemListener(this);
        poolside.addItemListener(this);
        lakeside.addItemListener(this);
        oneBed.addItemListener(this);
        twoBed.addItemListener(this);
        threeBed.addItemListener(this);
        meals.addItemListener(this);

        add(titleLabel);
        add(parkside);
        add(poolside);
        add(lakeside);
        add(oneBed);
        add(twoBed);
        add(threeBed);
        add(meals);
        add(totalPriceLabel);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JVacationRental jVacationRental = new JVacationRental();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        int select = e.getStateChange();

        if (source == parkside) {
            if (select == ItemEvent.SELECTED) {
                cabinSelected = PARKSIDE_PRICE;
            }
        }
        if (source == poolside) {
            if (select == ItemEvent.SELECTED) {
                cabinSelected = POOLSIDE_PRICE;
            }
        }
        if (source == lakeside) {
            if (select == ItemEvent.SELECTED) {
                cabinSelected = LAKESIDE_PRICE;
            }
        }
        if (source == oneBed) {
            if (select == ItemEvent.SELECTED) {
                bedSelected = ONE_BED_PRICE;
            }
        }
        if (source == twoBed) {
            if (select == ItemEvent.SELECTED) {
                bedSelected = TWO_BED_PRICE;
            }
        }
        if (source == threeBed) {
            if (select == ItemEvent.SELECTED) {
                bedSelected = THREE_BED_PRICE;
            }
        }
        if (source == meals) {
            if (select == ItemEvent.SELECTED) {
                mealSelected = MEAL_PRICE;
            }
            if (select == ItemEvent.DESELECTED) {
                  mealSelected = mealSelected - MEAL_PRICE; 
            }
        }
        totalPriceLabel.setText("Total price: $" + (cabinSelected + bedSelected + mealSelected));
    }
}
