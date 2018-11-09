package Gestio.Empleats;

import Biblioteques.IO;
import Clases.Empleat;
import Clases.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alta_empleats {
    private JTextField empleat_nom;
    private JTextField empleat_cognoms;
    private JTextField empleats_dni;
    private JTextField empleats_nomina;
    private JButton registrarEmpleats;
    private JButton enrereButton;
    private JButton cancelarButton;
    private JPanel panelAltaEmpleats;
    private static JFrame frame_menuAltaEmpleats = new JFrame("panelAltaEmpleats");

    public Alta_empleats() {
        enrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_menuAltaEmpleats.setVisible(false);
                Gestio.Empleats.Menu_empleats.mostar_menu_empleats();
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_menuAltaEmpleats.dispose();
                Gestio.Empleats.Menu_empleats.mostar_menu_empleats();
            }
        });
        registrarEmpleats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (empleat_nom.getText().isEmpty() || empleat_cognoms.getText().isEmpty() || empleats_dni.getText().isEmpty() || empleats_nomina.getText().isEmpty()){
                    IO.imprimirTI("Se ha intentat registrar un empleat en algun camp buit");
                }else {
                    try{
                        Persona.arrayPersones[Persona.getContador()] = new Empleat();
                        Persona.arrayPersones[Persona.getContador()].setNom(empleat_nom.getText());
                        Persona.arrayPersones[Persona.getContador()].setCognom1(empleat_cognoms.getText());
                        Persona.arrayPersones[Persona.getContador()].setDNI(empleats_dni.getText());
                        ((Empleat) Persona.arrayPersones[Persona.getContador()]).setNomina(empleats_nomina.getText());
                        Persona.augmentarPersona();
                        IO.imprimirTI("Se ha registrat un empleat");

                        JOptionPane.showMessageDialog(frame_menuAltaEmpleats, "Empleat donat de alta correctament");
                        frame_menuAltaEmpleats.setVisible(false);
                        Gestio.Empleats.Menu_empleats.mostar_menu_empleats();


                        IO.imprimirTI("-------------------------------------------------------------------------");

                        /** IMPRIMIR EMPLEATS (PERSONES) */
                        for (int i=0; i<Persona.getContador(); i++){
                            IO.imprimirTI(Persona.arrayPersones[i].getNom());
                            IO.imprimirTI(Persona.arrayPersones[i].getCognom1());
                            IO.imprimirTI(Persona.arrayPersones[i].getDNI());
                            IO.imprimirTI(((Empleat)Persona.arrayPersones[i]).getNomina());
                        }

                    }catch (Exception ex){
                        IO.imprimirTI("Error al introduir un empleat " + ex);
                    }
                }

            }
        });
    }


    public static void Menu_alta_empleats(){
        frame_menuAltaEmpleats.setContentPane(new Alta_empleats().panelAltaEmpleats);
        frame_menuAltaEmpleats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_menuAltaEmpleats.pack();
        frame_menuAltaEmpleats.setVisible(true);
        frame_menuAltaEmpleats.setLocationRelativeTo(null);
    }

    public static void mostar_menu_alta_empleats(){
        frame_menuAltaEmpleats.setVisible(true);
    }
}

