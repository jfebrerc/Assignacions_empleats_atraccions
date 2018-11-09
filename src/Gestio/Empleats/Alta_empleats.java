package Gestio.Empleats;

import javax.swing.*;

public class Alta_empleats {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panelAltaEmpleats;
    private static JFrame frame_menuAltaEmpleats = new JFrame("panelAltaEmpleats");

    public static void Menu_alta_empleats(){
        frame_menuAltaEmpleats.setContentPane(new Alta_empleats().panelAltaEmpleats);
        frame_menuAltaEmpleats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_menuAltaEmpleats.pack();
        frame_menuAltaEmpleats.setVisible(true);
    }
}

