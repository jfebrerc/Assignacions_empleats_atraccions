package Gestio.Empleats;

import javax.swing.*;
import java.awt.event.*;

public class Llista_empleats extends javax.swing.JFrame{
    private JPanel llistaEmpleats;
    private JList jList1;
    private JButton llistarButton;
    private static JFrame frame_llistaEmpleats = new JFrame("llistaEmpleats");

    public static void Menu_llista_empleats(){
            frame_llistaEmpleats.setContentPane(new Llista_empleats().llistaEmpleats);
            frame_llistaEmpleats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame_llistaEmpleats.pack();
            frame_llistaEmpleats.setVisible(true);
            frame_llistaEmpleats.setLocationRelativeTo(null);
    }

    public Llista_empleats() {
        jList1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        jList1.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                super.componentAdded(e);
            }
        });
        llistarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel d1m = new DefaultListModel();
                for (int j=0; j<10; j++){
                    d1m.addElement("Element: " + j);
                }
                jList1.setModel(d1m);
            }
        });
    }
}
