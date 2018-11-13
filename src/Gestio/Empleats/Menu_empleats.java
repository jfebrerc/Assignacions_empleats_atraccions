package Gestio.Empleats;

import Clases.Persona;
import Main.main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                frame_menuEmpleats.setVisible(false);
                Gestio.Empleats.Alta_empleats.Menu_alta_empleats();
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
