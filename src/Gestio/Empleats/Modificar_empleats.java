package Gestio.Empleats;

import Biblioteques.Auxiiliar;
import Biblioteques.IO;
import Clases.Empleat;
import Clases.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
    private JTextField cercaEmpleat;
    private static JFrame frame_modificarEmpleats = new JFrame("modificarEmpleats");
    private Object indices2;
    private int seleccio;

    public Modificar_empleats()  {
        llistarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Auxiiliar.llistar_empleats(cercaEmpleat, Jlist3);
                /*DefaultListModel d1m = new DefaultListModel();
                for (int j = 0; j< Persona.getContador(); j++){
                    if (Persona.arrayPersones[j] instanceof Empleat) {
                        d1m.addElement(Persona.arrayPersones[j].toString());
                    }
                }
                Jlist3.setModel(d1m);*/
            }
        });
        carregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    boolean trobar=false;
                    JButton carregarButton = new JButton("Carregar");
                    getContentPane().add(carregarButton);
                    indices2=Jlist3.getSelectedValue();
                    IO.imprimirTI("Contingut seleccio: "+ (indices2));
                    for (int i=0; i<Persona.getContador(); i++){
                        if (indices2.toString().equalsIgnoreCase(Persona.arrayPersones[i].toString())){
                            seleccio=i;
                            IO.imprimirTI("Carregar index "+i);
                            nomField.setText(Persona.arrayPersones[i].getNom());
                            cognomField.setText(Persona.arrayPersones[i].getCognom1());
                            dniField.setText(Persona.arrayPersones[i].getDNI());
                            nominaField.setText(((Empleat) Persona.arrayPersones[i]).getNomina());
                            Auxiiliar.llistar_empleats(cercaEmpleat, Jlist3);
                            trobar=true;
                        }
                    }
                    if (!trobar){
                        IO.imprimirTI("element no trobat");
                        JOptionPane.showMessageDialog(frame_modificarEmpleats, "Selecciona un empleat");
                    }
                }catch(Exception error){
                    IO.imprimirTI("Error: "+ error);
                }



                /*JButton carregarButton = new JButton("carregarButton");
                getContentPane().add(carregarButton);
                IO.imprimirTI("Seleccio:");
                indices= Jlist3.getSelectedIndices();*/

                /*for (int i=0; i<indices.length;i++){
                    IO.imprimirTI("indice " + indices[i]);
                }*/
                /*
                for(empleat=0;empleat<indices.length;empleat++){
                    IO.imprimirTI("VALOR FOR: " + empleat);
                    IO.imprimirTI("Index empleats: " + indices[empleat]);
                    nomField.setText(Persona.arrayPersones[indices[empleat]].getNom());
                    cognomField.setText(Persona.arrayPersones[indices[empleat]].getCognom1());
                    dniField.setText(Persona.arrayPersones[indices[empleat]].getDNI());
                    nominaField.setText(((Empleat) Persona.arrayPersones[indices[empleat]]).getNomina());
                }*/
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
                try{
                    IO.imprimirTI("Element seleccionat: "+seleccio);
                    Persona.arrayPersones[seleccio].setNom(nomField.getText());
                    Persona.arrayPersones[seleccio].setCognom1(cognomField.getText());
                    Persona.arrayPersones[seleccio].setDNI(dniField.getText());
                    ((Empleat) Persona.arrayPersones[seleccio]).setNomina(nominaField.getText());
                    JOptionPane.showMessageDialog(frame_modificarEmpleats, "Empleat modificat correctament");

                    Auxiiliar.llistar_empleats(cercaEmpleat, Jlist3);

                }catch (Exception error){
                    IO.imprimirTI("Error: "+error);
                }



                /*int empleat_back = empleat;
                empleat--;
                try{
                    IO.imprimirTI(""+ empleat);
                    Persona.arrayPersones[indices[empleat]].setNom(nomField.getText());
                    Persona.arrayPersones[indices[empleat]].setCognom1(cognomField.getText());
                    Persona.arrayPersones[indices[empleat]].setDNI(dniField.getText());
                    ((Empleat) Persona.arrayPersones[indices[empleat]]).setNomina(nominaField.getText());
                    JOptionPane.showMessageDialog(frame_modificarEmpleats, "Empleat modificat correctament");
                    IO.imprimirTI(""+empleat);
                    IO.imprimirTI(""+indices[empleat]);
                    empleat=empleat_back;
                }catch(Exception error){
                    IO.imprimirTI("Error al modificar empleat: " + error);
                }
                DefaultListModel d1m = new DefaultListModel();
                for (int j = 0; j< Persona.getContador(); j++){
                    if (Persona.arrayPersones[j] instanceof Empleat) {
                        d1m.addElement(Persona.arrayPersones[j].toString());
                    }
                }
                Jlist3.setModel(d1m);*/

            }
        });
        modificarEmpleats.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Auxiiliar.llistar_empleats(cercaEmpleat, Jlist3);
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
