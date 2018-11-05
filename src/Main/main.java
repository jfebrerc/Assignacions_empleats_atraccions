package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    private JButton registrarEmpleatButton;
    private JButton eliminarEmpleatsButton;
    private JButton modificarEmpleatsButton;
    private JButton llistarEmpleatsButton;
    private JButton testButton;
    private JButton sortirButton;
    private JPanel panelMain;

    public main() {
        registrarEmpleatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("main");
        frame.setContentPane(new main().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
