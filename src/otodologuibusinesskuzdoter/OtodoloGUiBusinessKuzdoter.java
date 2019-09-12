/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otodologuibusinesskuzdoter;

/**
 *
 * @author Verosffy
 */
public class OtodoloGUiBusinessKuzdoter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       GUI p=new GUI();
       p.keretalkoto();
       Jatekmester j=new Jatekmester();
       //átteszem a gui neveket a játékmesternél levő jatekosnevekbe.
       j.elso.nev=p.elso.getText();
       j.masodik.nev=p.masodik.getText();
       
    }
    
}
