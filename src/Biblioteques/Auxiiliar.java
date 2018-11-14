package Biblioteques;

import Clases.Empleat;
import Clases.Persona;

import javax.swing.*;
import java.util.Scanner;

public class Auxiiliar extends javax.swing.JFrame{
    /** Funcio per a carregar els menus principals */
    public static int menu(String[] opcio, int opcions){
        Scanner sc = new Scanner(System.in);       //Inicialització del Scanner
        IO.imprimirTI("------------ MENU ------------");
        for(int i=0; i<opcions; i++){    //Bucle per a recorrer i imprimir la array de les opcions
            IO.imprimirTI(opcio[i]);
        }
        IO.imprimirTI("------------------------------");
        IO.imprimirT("Selecciona una opcio: ");
        int posicio = 0;
        try {
            posicio = IO.llegirEnter();       //Selecció de la opció del menú
            if (posicio<=opcions && posicio>0){   //Comprovació de que la opció seleccionada es correcta
                return posicio;
            }
            else{   //Si no es correcta, envia missatge
                IO.imprimirTI("Error: introdueix un valor valid");
            }
        }catch (Exception e){
            IO.imprimirTI("Error: introdueix un valor valid");
        }
        return posicio;
    }

    /** Funcio per a carregar els menus secundaris */
    public static int menu_secundari(String[] opcio, int opcions){
        Scanner sc = new Scanner(System.in);       //Inicialització del Scanner
        for(int i=0; i<opcions; i++){    //Bucle per a recorrer i imprimir l'array de les opcions
            IO.imprimirTI(opcio[i]);
        }
        IO.imprimirTI("------------------------------");
        IO.imprimirT("Selecciona una opcio: ");
        int posicio = 0;
        try {
            posicio = IO.llegirEnter();       //Selecció de la opció del menú
            if (posicio<=opcions && posicio>0){   //Comprovació de que la opció seleccionada es correcta
                return posicio;
            }
            else{   //Si no es correcta, envia missatge
                IO.imprimirTI("Error: introdueix un valor valid");
            }
        }catch (Exception e){
            IO.imprimirTI("Error: introdueix un valor valid");
        }
        return posicio;
    }

    /** Funció per a demanar una confirmació */
    public static boolean confirmacio(String confirmacio){
        if (confirmacio.equals("Si") || confirmacio.equals("S") || confirmacio.equals("si") || confirmacio.equals("s")){
            return true;
        }else if (confirmacio.equals("No") || confirmacio.equals("N") || confirmacio.equals("no") || confirmacio.equals("n")){
            return false;
        }else{
            IO.imprimirTI("Introdueix una opció vàlida");
            return false;
        }
    }

    /** Funcio per a comprovar que una array no estigue plena*/
    public static boolean comprovar_llargaria(int total_array, int elements_array){
        boolean comprovacio;
        if (elements_array >= total_array){
            comprovacio = false;
        }else {
            comprovacio = true;
        }
        return comprovacio;
    }
    /** FUNCIO PER A LLISTAR I BUSCAR EMPLEATS */
    public static void llistar_empleats(JTextField cercaEmpleat, JList jLlista){
        String cerca = cercaEmpleat.getText();
        IO.imprimirTI("Cerca: " + cerca);
        DefaultListModel d1m = new DefaultListModel();
        String titol_columna = String.format("%s %71s %69s %71s", "NOM", "COGNOM", "DNI", "NOMINA");
        String divisor = "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
        d1m.addElement(titol_columna);
        d1m.addElement(divisor);
        if (Persona.getContador()>15){
            if (cerca.equals("")){
                for (int j = 0; j< 15; j++){
                    if (Persona.arrayPersones[j] instanceof Empleat && Persona.arrayPersones[j].getNom().contains(cerca) || Persona.arrayPersones[j].getCognom1().contains(cerca) || Persona.arrayPersones[j].getDNI().contains(cerca) || ((Empleat) Persona.arrayPersones[j]).getNomina().contains(cerca)) {
                        d1m.addElement(Persona.arrayPersones[j].toString());
                    }
                }
                jLlista.setModel(d1m);
            }else{
                for (int j = 0; j< Persona.getContador(); j++){
                    if (Persona.arrayPersones[j] instanceof Empleat && Persona.arrayPersones[j].getNom().contains(cerca) || Persona.arrayPersones[j].getCognom1().contains(cerca) || Persona.arrayPersones[j].getDNI().contains(cerca) || ((Empleat) Persona.arrayPersones[j]).getNomina().contains(cerca)) {
                        d1m.addElement(Persona.arrayPersones[j].toString());
                    }
                }
                jLlista.setModel(d1m);
            }

        }else{
            for (int j = 0; j< Persona.getContador(); j++){
                if (Persona.arrayPersones[j] instanceof Empleat && Persona.arrayPersones[j].getNom().contains(cerca) || Persona.arrayPersones[j].getCognom1().contains(cerca) || Persona.arrayPersones[j].getDNI().contains(cerca) || ((Empleat) Persona.arrayPersones[j]).getNomina().contains(cerca)) {
                    d1m.addElement(Persona.arrayPersones[j].toString());
                }
            }
            jLlista.setModel(d1m);
        }
    }

    public static void llistar_empleatsNoTitol(JTextField cercaEmpleat, JList jLlista){
        String cerca = cercaEmpleat.getText();
        DefaultListModel d1m = new DefaultListModel();
        if (Persona.getContador()>10){
            for (int j = 0; j< 10; j++){
                if (Persona.arrayPersones[j] instanceof Empleat && Persona.arrayPersones[j].getNom().contains(cerca) || Persona.arrayPersones[j].getCognom1().contains(cerca) || Persona.arrayPersones[j].getDNI().contains(cerca) || ((Empleat) Persona.arrayPersones[j]).getNomina().contains(cerca)) {
                    d1m.addElement(Persona.arrayPersones[j].toString());
                }
            }
            jLlista.setModel(d1m);
        }else{
            for (int j = 0; j< Persona.getContador(); j++){
                if (Persona.arrayPersones[j] instanceof Empleat && Persona.arrayPersones[j].getNom().contains(cerca) || Persona.arrayPersones[j].getCognom1().contains(cerca) || Persona.arrayPersones[j].getDNI().contains(cerca) || ((Empleat) Persona.arrayPersones[j]).getNomina().contains(cerca)) {
                    d1m.addElement(Persona.arrayPersones[j].toString());
                }
            }
            jLlista.setModel(d1m);
        }
    }

    public static void llistar_empleatsTots(JTextField cercaEmpleat, JList jLlista) {
        String cerca = cercaEmpleat.getText();
        DefaultListModel d1m = new DefaultListModel();
        String titol_columna = String.format("%s %71s %69s %71s", "NOM", "COGNOM", "DNI", "NOMINA");
        String divisor = "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
        d1m.addElement(titol_columna);
        d1m.addElement(divisor);
        for (int j = 0; j< Persona.getContador(); j++){
            if (Persona.arrayPersones[j] instanceof Empleat && Persona.arrayPersones[j].getNom().contains(cerca) || Persona.arrayPersones[j].getCognom1().contains(cerca) || Persona.arrayPersones[j].getDNI().contains(cerca) || ((Empleat) Persona.arrayPersones[j]).getNomina().contains(cerca)) {
                d1m.addElement(Persona.arrayPersones[j].toString());
            }
        }
        jLlista.setModel(d1m);
        }
    }
