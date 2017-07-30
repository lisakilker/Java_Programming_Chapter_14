/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W3HW;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Lisa
 */
public class JFrameDisableButton2 extends JFrame implements ActionListener {

    JLabel nameLabel = new JLabel("Enter your name: ");
    JTextField nameTextField = new JTextField(15);
    JLabel nameResultLabel = new JLabel();
    JLabel enoughLabel = new JLabel();
    JButton nameButton = new JButton();
    int count = 0;

    public JFrameDisableButton2() {

        setTitle("JFrame Disable Button 2");
        setSize(650, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);

        add(nameLabel);
        add(nameTextField);
        add(nameButton);
        add(nameResultLabel);
        add(enoughLabel);

        nameResultLabel.setText("Your name is...");
        nameButton.setText("Enter");
        
        nameButton.addActionListener(this);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrameDisableButton2 action = new JFrameDisableButton2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        if (count < 7) {
            nameResultLabel.setText("Your name is " + nameTextField.getText() + "!");
        } else {
            nameResultLabel.setText("Your name is " + nameTextField.getText() + "!");
            enoughLabel.setEnabled(true);
            enoughLabel.setText("That's enough!");
            nameButton.setEnabled(false);
        }
    }
}

