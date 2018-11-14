package Gestio.Empleats;

import Biblioteques.IO;
import Clases.Empleat;
import Clases.Persona;
import Main.main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

public class Menu_empleats {
    private JButton registrarEmpleatButton;
    private JButton llistarEmpleatsButton;
    private JButton modificarEmpleatsButton;
    private JButton eliminarEmpleatsButton;
    private JButton testButton;
    private JButton sortirButton;
    private JPanel panelEmpleats;
    private static JFrame frame_menuEmpleats = new JFrame("Menu_empleats");

    public Menu_empleats() {
        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_menuEmpleats.setVisible(false);
                Main.main.mostrar_menu_principal();
            }
        });
        registrarEmpleatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Persona.getContador()>=Persona.getMaximPersones()){
                    JOptionPane.showMessageDialog(frame_menuEmpleats, "No es poden afegir mes usuaris, fica't en contacte amb el administrador");
                }else{
                    frame_menuEmpleats.setVisible(false);
                    Gestio.Empleats.Alta_empleats.Menu_alta_empleats();
                }
            }
        });
        llistarEmpleatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_menuEmpleats.setVisible(false);
                Gestio.Empleats.Llista_empleats.Menu_llista_empleats();
            }
        });
        eliminarEmpleatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_menuEmpleats.setVisible(false);
                Gestio.Empleats.Eliminar_empleats.Menu_eliminar_empleats();
            }
        });
        modificarEmpleatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_menuEmpleats.setVisible(false);
                Gestio.Empleats.Modificar_empleats.Menu_modificar_empleats();
            }
        });
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Persona.getContador()-40>=Persona.getMaximPersones()){
                    JOptionPane.showMessageDialog(frame_menuEmpleats, "No es poden afegir mes usuaris, fica't en contacte amb el administrador");
                }else{
                    try{
                        for (int i=Persona.getContador(); i<40;i++){
                            Persona.arrayPersones[i] = new Empleat();
                            Persona.arrayPersones[i].setId(Persona.arrayPersones[i].hashCode());
                            Persona.arrayPersones[i].setNom("nom"+(i+1));
                            Persona.arrayPersones[i].setCognom1("cognom"+(i+1));
                            Persona.arrayPersones[i].setDNI("dni"+(i+1));
                            ((Empleat) Persona.arrayPersones[i]).setNomina("nomina"+(i+1));
                            Persona.augmentarPersona();
                            IO.imprimirTI(Persona.arrayPersones[i].getIdentificador()+ "\t" + Persona.arrayPersones[i].toString());
                        }
                        JOptionPane.showMessageDialog(frame_menuEmpleats, "Empleats de prova carregats correctament");
                    }catch (Exception error){
                        IO.imprimirTI("Error: " + error);
                    }
                }
            }
        });
    }

    public static void Menu_empleats(){
        frame_menuEmpleats.setContentPane(new Menu_empleats().panelEmpleats);
        frame_menuEmpleats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_menuEmpleats.pack();
        frame_menuEmpleats.setVisible(true);
        frame_menuEmpleats.setLocationRelativeTo(null);

    }

    public static void mostar_menu_empleats(){
        frame_menuEmpleats.setVisible(true);
    }
}
