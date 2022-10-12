package clasesinternas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import javax.swing.*;

public class Temporizador {

    public static void main(String[] args) {

        Reloj mireloj = new Reloj(3000,true);
        mireloj.enMarcha();
        JOptionPane.showMessageDialog(null, "Pulsa Aceptar para terminar");
        System.exit(0);

    }
}

class Reloj{

    public Reloj(int intervalo, boolean sonido){
        this.intervalo=intervalo;
        this.sonido=sonido;
    }

    public void enMarcha(){
        ActionListener oyente = new DameLaHora2();
        Timer mitemporizador = new Timer(intervalo, oyente);
        mitemporizador.start();
    }

    private int intervalo;
    private boolean sonido;

    private class DameLaHora2 implements ActionListener{

        public void actionPerformed(ActionEvent evento){
            Date ahora = new Date();
            System.out.println("Te pongo la hora cada 3 sg " + ahora);
            if(sonido){
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}


