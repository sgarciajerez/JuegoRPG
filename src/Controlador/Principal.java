package Controlador;
import java.util.Scanner;

import Modelo.Personaje;
import Modelo.Personaje.Liga;

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

    public static int introducirNumero(){
        int numeroIntroducido;
        System.out.println("Introduce una opción: ");
        numeroIntroducido=lector.nextInt();
        lector.nextLine(); //limpiamos buffer
        return numeroIntroducido;
    }

    public static void mostrarError(int numeroError){
        switch(numeroError){
            case 1 : {
                System.out.println("Introduzca un numero válido por favor");
                
            }
            case 2 : {
                System.out.println("Esta funcionalidad se encuentra en desarrollo");
            }
            default : {

            }
        }
    }

    public static int menuPrincipal(){
        int opcionSeleccionada;
        limpiarPantalla();
        System.out.println("----------------RPG CAT AVENGERS-------------------");
        System.out.println("-------------Selecccione una opción----------------");
        System.out.println("- 1.- Modo Invidual -------------------------------");
        System.out.println("- 2.- Batallas Grupales ---------------------------");
        System.out.println("- 0.- Salir ---------------------------------------");
        System.out.println("---------------------------------------------------");
        opcionSeleccionada=introducirNumero();
        return opcionSeleccionada;
    }

    public static int menuBatallaIndividual(){
        int opcionSeleccionada;
        limpiarPantalla();
        System.out.println("-------RPG CAT AVENGERS: BATALLA INDIVIDUAL--------");
        System.out.println("-------------Selecccione una opción----------------");
        System.out.println("- 1.- Crear Personaje -----------------------------");
        System.out.println("- 2.- Mostrar Personajes Creados ------------------");
        System.out.println("- 3.- Batallar ------------------------------------");
        System.out.println("- 0.- Salir ---------------------------------------");
        System.out.println("---------------------------------------------------");
        opcionSeleccionada=introducirNumero();
        return opcionSeleccionada;
    }

    public static void main(String[] args) {


        int opcionSeleccionada=menuPrincipal();
        int opcionSubmenu;

        do{
            switch(opcionSeleccionada){
                case 1: {
                    //Modo Individual
                    do {
                        opcionSubmenu=menuBatallaIndividual();
                        switch(opcionSubmenu){
                            
                            case 1: {
                                //Crear Personaje
                            }
                            case 2: {
                                //Mostrar info del personaje
                            }
                            case 3: {
                                //Batallar
                            }
                            case 4 : {
                                //Volver al menú principal
                            }
                            default : {

                            }
                        }

                    } while (opcionSubmenu!=4);
                } 
                
                case 2: {
                    mostrarError(2);
                } 
                
                default: {
                    mostrarError(1);
                }
            } 
        }while(opcionSeleccionada!=0);

        Personaje p1 = new Personaje("Remanente", Liga.JUVENIL);
        Personaje p2 = new Personaje("Terrorcito", Liga.TERROR);

        

    do {
        p2.realizarAtaque(p1);
        pulseIntro();
        p1.realizarAtaque(p2);
        pulseIntro();
    } while (p1.getVida()>0 && p2.getVida()>0);

    }
}
