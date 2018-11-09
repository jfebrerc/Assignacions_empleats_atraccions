package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Clases.Persona;

public class main {
    private JButton gestioEmpleatButton;
    private JButton gestioYButton;
    private JButton gestioXButton;
    private JButton testButton;
    private JButton sortirButton;
    private JPanel panelMain;
    private static JFrame frame_main = new JFrame("main");
    //public Persona[] arrayPersones = new Persona[Persona.getMaximPersones()];

    public main() {
        gestioEmpleatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_main.setVisible(false);
                Gestio.Empleats.Menu_empleats.Menu_empleats();
            }
        });
        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame_main.dispose();
            }
        });
    }

    public static void main(String[] args){
        frame_main.setContentPane(new main().panelMain);
        frame_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_main.pack();
        frame_main.setVisible(true);
        frame_main.setLocationRelativeTo(null);
    }

    public static void mostrar_menu_principal(){
        frame_main.setVisible(true);
    }
}
