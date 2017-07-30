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
public class JFrameDisableButton extends JFrame implements ActionListener {

    JLabel nameLabel = new JLabel("Enter your name: ");
    JTextField nameTextField = new JTextField(15);
    JLabel nameResultLabel = new JLabel();
    JButton nameButton = new JButton();

    public JFrameDisableButton() {
        
        setTitle("JFrame Disable Button");
        setSize(650, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);

        add(nameLabel);
        add(nameTextField);
        add(nameButton);
        add(nameResultLabel);

        nameResultLabel.setText("Your name is...");
        nameButton.setText("Enter");

        nameButton.addActionListener(this);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrameDisableButton action = new JFrameDisableButton();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nameResultLabel.setText("Your name is " + nameTextField.getText() + "!");
        nameButton.setEnabled(false);
    }
}
