/**
 * Classe filla de Persona
 */
package Clases;

public class Empleat extends Persona { //Comentaris al marge per als atributs
    private String codiSS;
    private String especialitat;
    private String carrec;
    private String dataContracte;
    private String dataFinalContracte;
    private String iban;

    public Empleat() {
        super();
    }

    /** GETTERS */
    public String getCodiSS() {
        return codiSS;
    }
    public String getEspecialitat(){
        return especialitat;
    }
    public String getCarrec(){
        return carrec;
    }
    public String getDataContracte(){
        return dataContracte;
    }
    public String getDataFinalContracte(){
        return dataFinalContracte;
    }
    public String getIban(){
        return iban;
    }

    /** SETTERS */
    public void setCodiSS(String s){
        codiSS = s;
    }
    public void setEspecialitat(String s){
        especialitat = s;
    }
    public void setCarrec(String s){
        carrec = s;
    }
    public void setDataContracte(String s){
        dataContracte = s;
    }
    public void setDataFinalContracte (String s){
        dataFinalContracte = s;
    }
    public void setIban(String s){
        iban = s;
    }

    /** METODES */

    @Override
    public String toString() {
        String imprimir = getNom();
        return imprimir;
    }


}