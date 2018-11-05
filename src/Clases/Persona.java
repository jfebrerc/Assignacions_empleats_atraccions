/** Classe principal de persones */

package Clases;

public class Persona {
    private static int contador = 0;
    private static final int TOTAL_PERSONES = 1000;
    /* Atributs */
    protected String nom;
    protected String cognom1;
    protected String cognom2;
    protected String id;
    protected String passwd;

    /** CONSTRUCTOR */
    public Persona() {
    }

    public String getNom() {
        return nom;
    }

    /** SETTERS */
    public void setNom(String n) {
        nom = n;
    }

    public void setCognom1(String c1) {
        cognom1 = c1;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom2(String c2) {
        cognom2 = c2;
    }

    public void setIdentificador(String i) {
        id = i;
    }

    public void setPasswd(String pwd) {
        passwd = pwd;
    }

    /** GETTERS */
    public String getCognom2() {
        return cognom2;
    }

    public String getIdentificador() {
        return id;
    }

    public String getPasswd() {
        return passwd;
    }

    public int getContador(){
        return contador;
    }


    /** METODES */
    public int augmentarPersones(int n){
        contador = contador + n;
        return contador;
    }

    @Override
    public String toString() {
        String imprimir = getNom();
        return imprimir;
    }
}
