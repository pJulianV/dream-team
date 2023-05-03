package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalP {
    private JPanel panel1;
    private JButton buscarEnAPIButton;
    private JButton buscarEnDBButton;
    private JPanel panel2;

    public PrincipalP() {
        buscarEnDBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("DB Filter");
                frame.setContentPane(new dbFilter().panel1);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        buscarEnAPIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("API Filter");
                frame.setContentPane(new APIFilter().panel1);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public void setView() {
        JFrame frame = new JFrame("Top 10");
        frame.setContentPane(new PrincipalP().panel1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
