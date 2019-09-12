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
public class Jatekmester {

    Jatekos elso = new Jatekos();//    protected int elsoJ = 1;
    Jatekos masodik = new Jatekos();//    protected int masodikJ = 2;
    Jatekos nyertes = new Jatekos();
    int[][] palya;//ezek helyett csináltam a játékosnak példanyszámlálót és a sorszáma lesz a lépésértéke(ha sikerül)
    int[] pozicio = new int[2];
    int lepesKeres;
    int ures = 0;
    boolean jatekban = true;

    final int elsoNyert = 10;
    final int masodikNyert = 5;
    String nyertesKiiras;

    public void jatekMozzanatEgyJateksonak(Jatekos jatekos) {
        palyaKezdo();
        lepesbekero(jatekos);
        oszlopKovetkezoSzabadHelye(lepesKeres, jatekos);
        palyaModosito(pozicio, jatekos);
        kiertekeles();

    }
    public void Jatekmenet(Jatekos e, Jatekos m){
        int szamlalo=0;
//        Jatekos kovJ=e;
if(szamlalo%2==elso.le)
        
        jatekMozzanatEgyJateksonak(e);
        
    }

    public void palyaKezdo() {
        palya = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                palya[i][j] = ures;
            }
        }

    }

    public int lepesbekero(Jatekos jatekos) {
        lepesKeres = jatekos.lepesvalasztas;
        return lepesKeres;
    }

    public void palyaModosito(int[] pozicio, Jatekos jatekos) {
        if (pozicio[0] == -1) {
            lepesbekero(jatekos);

        } else {
            palya[pozicio[0]][pozicio[1]] = jatekos.lepesErtek;
        }

    }

    public int[] oszlopKovetkezoSzabadHelye(int lepesKeres, Jatekos jatekos) {
        pozicio[0] = -1;

        for (int i = 4; i >= 0; i--) {

            if (palya[i][lepesKeres] == 0) {
                pozicio[0] = i;
                pozicio[1] = lepesKeres;
                break;

            }
        }

        return pozicio;
    }

    public Jatekos osszegErtekelo(int osszeg) {
        if (osszeg == elsoNyert) {
            nyertes = elso;
        } else if (osszeg == masodikNyert) {
            nyertes = masodik;
        }
        return nyertes;
    }

    public Jatekos kiertekeles() {

        int osszeg = 0;
        for (int i = 0; i < 5; i++) {
            osszeg = 0;
            for (int j = 0; j < 5; j++) {
                osszeg += palya[i][j];
            }

            osszegErtekelo(osszeg);

        }
        for (int i = 0; i < 10; i++) {
            osszeg = 0;
            for (int j = 0; j < 10; j++) {
                osszeg += palya[j][i];
            }
            osszegErtekelo(osszeg);
        }
        for (int i = 0; i < 5; i++) {
            osszeg += palya[i][5 - 1];
        }
        return osszegErtekelo(osszeg);

    }

}
