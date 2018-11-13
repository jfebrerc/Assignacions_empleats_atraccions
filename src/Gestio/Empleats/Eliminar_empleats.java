package Gestio.Empleats;

import Clases.Empleat;
import Clases.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Biblioteques.IO;


public class Eliminar_empleats extends javax.swing.JFrame{

    private JPanel eliminarEmpleats;
    private JList jList2;
    private JButton llistarButton;
    private JButton eliminarButton;
    private JButton cancelarButton;
    private static JFrame frame_eliminarEmpleats = new JFrame("eliminarEmpleats");

    public Eliminar_empleats() {
        llistarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel d1m = new DefaultListModel();
                for (int j = 0; j< Persona.getContador(); j++){
                    d1m.addElement(j+1 + " " + Persona.arrayPersones[j]);
                }
                jList2.setModel(d1m);
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton eliminarButton = new JButton("Eliminar");
                getContentPane().add(eliminarButton);
                IO.imprimirTI("Seleccio:");
                int [] indices= jList2.getSelectedIndices();
                for(int i=0;i<indices.length;i++){
                    IO.imprimirTI("Empleats eliminats: " + indices[i]);
                    //ELIMINAR EMPLEATS
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_eliminarEmpleats.setVisible(false);
                Menu_empleats.mostar_menu_empleats();
            }
        });
    }

    public static void Menu_eliminar_empleats(){
        frame_eliminarEmpleats.setContentPane(new Eliminar_empleats().eliminarEmpleats);
        frame_eliminarEmpleats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_eliminarEmpleats.pack();
        frame_eliminarEmpleats.setVisible(true);
        frame_eliminarEmpleats.setLocationRelativeTo(null);

    }
}
