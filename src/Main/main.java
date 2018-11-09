package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    private JButton gestioEmpleatButton;
    private JButton gestioYButton;
    private JButton gestioXButton;
    private JButton testButton;
    private JButton sortirButton;
    private JPanel panelMain;
    private static JFrame frame_main = new JFrame("main");

    public main() {
        gestioEmpleatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestio.Empleats.Menu_empleats.Menu_empleats();
                frame_main.setVisible(false);
            }
        });
    }

    public static void main(String[] args){
        frame_main.setContentPane(new main().panelMain);
        frame_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_main.pack();
        frame_main.setVisible(true);
    }

    public static void mostrar_menu_principal(){
        frame_main.setVisible(true);
    }
}
