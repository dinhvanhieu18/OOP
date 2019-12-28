package oop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import oop.controllers.query.ReadQuery;

class Frame {

    public static void main(String args[]) {
        JFrame f = new JFrame("TextField Example");
        final JTextField t2;
        JLabel t1 = new JLabel("Your query:");
        t1.setBounds(50, 100, 200, 30);
        t2 = new JTextField();
        t2.setFocusTraversalPolicyProvider(true);
        t2.setBounds(50, 150, 200, 30);

        JButton but = new JButton("Execute");
        but.setBounds(150, 200, 80, 25);
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String query = t2.getText();
                ReadQuery.Read(query);
            }
        });

        f.add(but);
        f.add(t1);
        f.add(t2);

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocation(400, 250);
        f.setSize(350, 350);
        f.setLayout(null);
        f.setVisible(true);
        String qaa = t2.getText();
        System.out.println("q");
    }
}
