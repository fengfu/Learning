package io.fengfu.learning.swing;

import javax.swing.*;

/**
 * Created by fengfu on 2017/4/10.
 */
public class FormDemo {
    private JTextField textField1;
    private JTextField textField2;
    private JPanel main;
    private JTextField textField3;
    private JTextField textField4;

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormDemo");
        frame.setContentPane(new FormDemo().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
