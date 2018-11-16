package Gestio.Empleats;

import Clases.Empleat;
import Clases.Persona;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import Biblioteques.IO;
import Clases.Persona;
import Biblioteques.Auxiiliar;
public class Eliminar_empleats extends javax.swing.JFrame{

    private JPanel eliminarEmpleats;
    private JList jList2;
    private JButton llistarButton;
    private JButton eliminarButton;
    private JButton cancelarButton;
    private JTextField cercaEmpleat;
    private static JFrame frame_eliminarEmpleats = new JFrame("eliminarEmpleats");
    //private int empleat;
    //private int [] indices;

    public Eliminar_empleats() {
        llistarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Biblioteques.Auxiiliar.llistar_empleats(cercaEmpleat, jList2);
                /*DefaultListModel d1m = new DefaultListModel();
                String titol_columna = String.format("%s %71s %69s %71s", "NOM", "COGNOM", "DNI", "NOMINA");
                String divisor = "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
                d1m.addElement(titol_columna);
                d1m.addElement(divisor);
                for (int j = 0; j< Persona.getContador(); j++){
                    if (Persona.arrayPersones[j] instanceof Empleat) {
                        d1m.addElement(Persona.arrayPersones[j].toString());
                    }
                }
                jList2.setModel(d1m);*/
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton eliminarButton = new JButton("Eliminar");
                getContentPane().add(eliminarButton);
                //indices= jList2.getSelectedIndices();
                Object indices2=jList2.getSelectedValue();
                IO.imprimirTI("Contingut seleccio: "+ (indices2));
                if (indices2 == null){
                    JOptionPane.showMessageDialog(frame_eliminarEmpleats, "Selecciona un empleat");
                }else {
                    if (Persona.getContador()<=0){
                        JOptionPane.showMessageDialog(frame_eliminarEmpleats, "No hi han empleats a eliminar");
                    }else{
                        try{
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Estas segur de que vols eliminar el empleat?", "CONFIRMACIO", dialogButton);
                            if(dialogResult == 0) {
                                IO.imprimirTI("Opcio 'SI'");
                                for (int i=0; i<Persona.getContador(); i++){
                                    if (indices2.toString().equalsIgnoreCase(Persona.arrayPersones[i].toString())){
                                        IO.imprimirTI("Eliminar index "+i);
                                        for ( int k = i ; k < Persona.getContador() - 1 ; k++)
                                        {
                                            Persona.arrayPersones[ k ] = Persona.arrayPersones[ k + 1 ] ;
                                        }
                                        Persona.eliminarPersona();
                                        IO.imprimirTI("Empleat eliminat.");
                                        JOptionPane.showMessageDialog(frame_eliminarEmpleats, "Empleat eliminat correctament");
                                        Auxiiliar.llistar_empleats(cercaEmpleat, jList2);
                                    }
                                }
                            } else {
                                IO.imprimirTI("Opcio 'NO'");
                            }



                        }catch (Exception error){
                            IO.imprimirTI("Error: "+error);
                        }
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
        eliminarEmpleats.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Auxiiliar.llistar_empleats(cercaEmpleat, jList2);
            }
        });
        cercaEmpleat.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Auxiiliar.llistar_empleats(cercaEmpleat, jList2);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Auxiiliar.llistar_empleats(cercaEmpleat, jList2);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                Auxiiliar.llistar_empleats(cercaEmpleat, jList2);
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
