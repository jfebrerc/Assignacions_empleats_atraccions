package Biblioteques;

import java.util.Scanner;

public class Auxiiliar {
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

}
