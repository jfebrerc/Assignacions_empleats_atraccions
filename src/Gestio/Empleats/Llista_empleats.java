package Gestio.Empleats;

import Biblioteques.IO;
import Clases.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Llista_empleats extends javax.swing.JFrame{
    private JPanel llistaEmpleats;
    private JList jList1;
    private JButton llistarButton;
    private JButton cancelarButton;
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
                for (int j = 0; j< Persona.getContador(); j++){
                    d1m.addElement(Persona.arrayPersones[j]);
                }
                jList1.setModel(d1m);
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_llistaEmpleats.setVisible(false);
                Menu_empleats.mostar_menu_empleats();
            }
        });
    }
}
