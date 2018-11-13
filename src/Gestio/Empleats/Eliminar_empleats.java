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
    private int empleat;
    private int [] indices;

    public Eliminar_empleats() {
        llistarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel d1m = new DefaultListModel();
                for (int j = 0; j< Persona.getContador(); j++){
                    d1m.addElement(Persona.arrayPersones[j]);
                }
                jList2.setModel(d1m);
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton eliminarButton = new JButton("Eliminar");
                getContentPane().add(eliminarButton);
                indices= jList2.getSelectedIndices();
                if (Persona.getContador()<=0){
                    JOptionPane.showMessageDialog(frame_eliminarEmpleats, "No hi han empleats a eliminar");
                }else{
                    try{

                        for(empleat=0;empleat<indices.length;empleat++){
                            IO.imprimirTI("Index empleats: " + indices[empleat]);
                            for ( int i = indices[empleat] ; i < Persona.getContador() - 1 ; i++ )
                            {
                                Persona.arrayPersones[ i ] = Persona.arrayPersones[ i + 1 ] ;
                            }
                            IO.imprimirTI("Empleat eliminat.");
                            Persona.eliminarPersona();
                        }
                        JOptionPane.showMessageDialog(frame_eliminarEmpleats, "Empleat eliminat correctament");
                        DefaultListModel d1m = new DefaultListModel();
                        for (int j = 0; j< Persona.getContador(); j++){
                            d1m.addElement(Persona.arrayPersones[j]);
                        }
                        jList2.setModel(d1m);
                    }catch (Exception error){
                        IO.imprimirTI("Error: " + error);
                    }
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
