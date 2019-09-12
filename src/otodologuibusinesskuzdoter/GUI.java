/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otodologuibusinesskuzdoter;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.BoxLayout.Y_AXIS;

/**
 *
 * @author Verosffy
 */
public class GUI {

    JButton[] oszlopok;
    JLabel[][] palyarajz;
    JTextField[] jatekosnevek;
    JLabel eredmenyKijelzo;
    JLabel cim;
    JPanel centerPanel;
    JFrame keret;

    JLabel elso;
    JLabel masodik;

    public void nevekbekero() {
        elso = new JLabel("Kezdő játékos");
        masodik = new JLabel("Második játékos");

        JTextField elsoNev = new JTextField("Ide írd a neved!");
        JTextField masodikNev = new JTextField("Ide írd a neved!");

        JButton ok = new JButton("Mehet");

        class OkGombFigyelo implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                elso.setText(elsoNev.getText());
                masodik.setText(masodikNev.getText());

                go();
            }

        }
        ok.addActionListener(new OkGombFigyelo());

        centerPanel.removeAll();
        centerPanel.setForeground(Color.red);
        centerPanel.add(elso);
        centerPanel.add(elsoNev);
        centerPanel.add(masodik);
        centerPanel.add(masodikNev);
        centerPanel.add(ok);

        keret.getContentPane().add(BorderLayout.CENTER, centerPanel);
        keret.setVisible(true);

    }

    public void keretalkoto() {

        keret = new JFrame();
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, Y_AXIS));

        keret.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cim = new JLabel("Ötödölő Ötöd Ölő Ő tő dől Ő Ő tödölő Ő tő dő lő Öt ödölő");

        JButton egyjatekos = new JButton("Egyedül játszom");
        JButton ketten = new JButton("Ketten játszunk");
        JLabel bekoszono = new JLabel("Ez itt az Ötödölő játék. Egyedül a gép ellen játszol, vagy ketten vagytok és egymás ellen szeretnétek játszani?");
        class Ketten implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                nevekbekero();
            }

        }
        ketten.addActionListener(new Ketten());
        centerPanel.add(bekoszono);
        centerPanel.add(egyjatekos);
        centerPanel.add(ketten);
        keret.getContentPane().add(centerPanel);
        keret.setSize(300, 300);
        keret.setVisible(true);

//        jatekosnevek = new JTextField[2];
//        for (int i = 0; i < 2; i++) {
//            jatekosnevek[i] = new JTextField("Írd ide a neved!");
//        }
    }

    public void go() {

        centerPanel.removeAll();

//letrehozza a gombokat, a jelolo labeleket tartalmazo tomboket
        oszlopok = new JButton[5];
        palyarajz = new JLabel[5][5];
// ez a forban for létrehozza az 5 gombot és az 5*5 labelt
        for (int i = 0; i < 5; i++) {
            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);

            Color rColor = new Color(r, g, b);
            String nev = "" + i;
            oszlopok[i] = new JButton(nev);
            oszlopok[i].setBackground(rColor);
            for (int j = 0; j < 5; j++) {
                String ind = "  " + i + ";" + j + "  ";
                palyarajz[i][j] = new JLabel(ind);
                palyarajz[i][j].setBackground(rColor);
                palyarajz[i][j].setForeground(rColor);
            }

        }

       
        JButton start=new JButton("Kezdjük!");
        class Kezdjuk implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                jatekmenet();
            }
         
        }
        start.addActionListener(new Kezdjuk());
        //most felpakolom a kesz elemeket panelre, illetve borderbe.
        JPanel[] panelsor = new JPanel[6];

        panelsor[0] = new JPanel();
        for (int i = 0; i < 5; i++) {

            panelsor[0].add(oszlopok[i]);
        }

        for (int i = 0; i < 5; i++) {
            panelsor[(i + 1)] = new JPanel();
            for (int j = 0; j < 5; j++) {
                panelsor[(i + 1)].add(palyarajz[i][j]);
            }

        }
        for (int i = 0; i < 6; i++) {
            centerPanel.add(panelsor[i]);
        }

        keret.getContentPane().add(BorderLayout.NORTH, cim);
        keret.getContentPane().add(BorderLayout.EAST, elso);
        keret.getContentPane().add(BorderLayout.WEST, masodik);
        
        keret.getContentPane().add(BorderLayout.SOUTH, start);
        keret.getContentPane().add(BorderLayout.CENTER, centerPanel);
        keret.setSize(600, 600);
        keret.setVisible(true);
    }
    public void jatekmenet(){
        
        
    
    
    }
}
