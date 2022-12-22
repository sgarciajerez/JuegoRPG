package Controlador;
import Modelo.Personaje;

public class Principal {
    public static void main(String[] args) throws Exception {
        Personaje p1 = new Personaje("Remanente", "TERROR");
        Personaje p2 = new Personaje("Terrorcito", "JUSTICIA");

    do {
        p2.ataque(p1);
        p1.ataque(p2);
        System.out.println(p1.getVida());
        System.out.println(p2.getVida());
    } while (p1.getVida()>0 && p2.getVida()>0);

    }
}
