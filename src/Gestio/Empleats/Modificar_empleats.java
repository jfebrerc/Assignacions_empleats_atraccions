package Gestio.Empleats;

import Biblioteques.IO;
import Clases.Empleat;
import Clases.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modificar_empleats extends javax.swing.JFrame{
    private JPanel modificarEmpleats;
    private JList Jlist3;
    private JButton llistarButton;
    private JButton carregarButton;
    private JButton modificarButton;
    private JButton cancelarButton;
    private JTextField nomField;
    private JTextField cognomField;
    private JTextField dniField;
    private JTextField nominaField;
    private static JFrame frame_modificarEmpleats = new JFrame("modificarEmpleats");
    private int empleat;
    private int [] indices;

    public Modificar_empleats()  {
        llistarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel d1m = new DefaultListModel();
                for (int j = 0; j< Persona.getContador(); j++){
                    d1m.addElement(Persona.arrayPersones[j]);
                }
                Jlist3.setModel(d1m);
            }
        });
        carregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton carregarButton = new JButton("carregarButton");
                getContentPane().add(carregarButton);
                IO.imprimirTI("Seleccio:");
                indices= Jlist3.getSelectedIndices();

                /*for (int i=0; i<indices.length;i++){
                    IO.imprimirTI("indice " + indices[i]);
                }*/

                for(empleat=0;empleat<indices.length;empleat++){
                    IO.imprimirTI("VALOR FOR: " + empleat);
                    IO.imprimirTI("Index empleats: " + indices[empleat]);
                    nomField.setText(Persona.arrayPersones[indices[empleat]].getNom());
                    cognomField.setText(Persona.arrayPersones[indices[empleat]].getCognom1());
                    dniField.setText(Persona.arrayPersones[indices[empleat]].getDNI());
                    nominaField.setText(((Empleat) Persona.arrayPersones[indices[empleat]]).getNomina());
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_modificarEmpleats.setVisible(false);
                Gestio.Empleats.Menu_empleats.mostar_menu_empleats();
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empleat--;
                try{
                    IO.imprimirTI(""+ empleat);
                    Persona.arrayPersones[indices[empleat]].setNom(nomField.getText());
                    Persona.arrayPersones[indices[empleat]].setCognom1(cognomField.getText());
                    Persona.arrayPersones[indices[empleat]].setDNI(dniField.getText());
                    ((Empleat) Persona.arrayPersones[indices[empleat]]).setNomina(nominaField.getText());
                    JOptionPane.showMessageDialog(frame_modificarEmpleats, "Empleat modificat correctament");
                }catch(Exception error){
                    IO.imprimirTI("Error al modificar empleat: " + error);
                }

            }
        });
    }

    public static void Menu_modificar_empleats(){
        frame_modificarEmpleats.setContentPane(new Modificar_empleats().modificarEmpleats);
        frame_modificarEmpleats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_modificarEmpleats.pack();
        frame_modificarEmpleats.setVisible(true);
        frame_modificarEmpleats.setLocationRelativeTo(null);

    }


}
