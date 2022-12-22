package Controlador;
import java.util.Scanner;

import Modelo.Personaje;

public class Principal {

    public static Scanner lector = new Scanner(System.in);

    public static void limpiarPantalla(){
        int espacios=200;
        for (int i=0; i<espacios; i++){
            System.out.println("");
        }
    }

    public static void pulseIntro (){
        System.out.println("Pulse Intro...");
        lector.nextLine();
        limpiarPantalla();
    }

    public static void main(String[] args) throws Exception {
        Personaje p1 = new Personaje("Remanente", "TERROR");
        Personaje p2 = new Personaje("Terrorcito", "JUSTICIA");

    do {
        p2.realizarAtaque(p1);
        pulseIntro();
        p1.realizarAtaque(p2);
        pulseIntro();
    } while (p1.getVida()>0 && p2.getVida()>0);

    }
}
