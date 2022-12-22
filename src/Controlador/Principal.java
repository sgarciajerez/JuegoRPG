package Controlador;
import java.util.Scanner;

import Modelo.Coliseo;
import Modelo.Personaje;
import Modelo.Coliseo.tipoColiseo;
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
                break;
            }
            case 2 : {
                System.out.println("Esta funcionalidad se encuentra en desarrollo");
                break;
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
        System.out.println("- 4.- Salir ---------------------------------------");
        System.out.println("---------------------------------------------------");
        opcionSeleccionada=introducirNumero();
        return opcionSeleccionada;
    }
    public static int menuPersonaje(){
        int opcionSeleccionada;
        limpiarPantalla();
        System.out.println("------RPG CAT AVENGERS: CREACIÓN DE PERSONAJE------");
        System.out.println("-------------Selecccione una opción----------------");
        System.out.println("- 1.- Crear Personaje dando Atributos -------------");
        System.out.println("- 2.- Crear Personaje con Atributos aleatorios ----");
        System.out.println("- 3.- Salir ---------------------------------------");
        System.out.println("---------------------------------------------------");
        opcionSeleccionada=introducirNumero();
        return opcionSeleccionada;
    }

    public static Coliseo crearColiseo(){
        String nombreColiseo;
        Coliseo coliseoCreado;
        System.out.println("Antes de empezar, dame un nombre para tu Arena de Batalla: ");
        nombreColiseo=lector.nextLine();
        return coliseoCreado = new Coliseo(nombreColiseo);
    }

    public static Liga pedirLiga(){
        int opcion;
        Liga liga = null;
        boolean opcionValida;
        do{
            opcionValida=true;
            System.out.println("---------------LIGA DE TU PERSONAJE----------------");
            System.out.println("-------------Selecccione una opción----------------");
            System.out.println("- 1.- JUSTICIA ------------------------------------");
            System.out.println("- 2.- JUVENIL -------------------------------------");
            System.out.println("- 3.- NEUTRAL -------------------------------------");
            System.out.println("- 4.- PICARO --------------------------------------");
            System.out.println("- 5.- TERROR --------------------------------------");
            System.out.println("---------------------------------------------------");
            opcion=introducirNumero();

            switch(opcion){
                case 1 : {
                    liga=Liga.JUSTICIA;
                    break;
                }
                case 2 : {
                    liga=Liga.JUVENIL;
                    break;
                }
                case 3 : {
                    liga = Liga.NEUTRAL;
                    break;
                }
                case 4 : {
                    liga = Liga.PICARO;
                    break;
                }
                case 5 : {
                    liga = Liga.TERROR;
                    break;
                }
                default : {
                    mostrarError(1);
                    opcionValida=false;
                    break;
                }
            }  
        } while (!opcionValida);
        return liga;
    }

    public static Personaje crearPersonajeConAtributos(){
        String nombre;
        Liga liga;
        Personaje personajeCreado;
        int vida, ataque, defensa, ataqueSpecial, defensaSpecial, velocidad;

        System.out.println("Dame el nombre del personaje: ");
        nombre=lector.nextLine();
        liga=pedirLiga();
        System.out.println("Dame la vida del personaje: ");
        vida=introducirNumero();
        System.out.println("Dame el ataque del personaje: ");
        ataque=introducirNumero();
        System.out.println("Dame la defensa del personaje: ");
        defensa=introducirNumero();
        System.out.println("Dame el ataque especial del personaje: ");
        ataqueSpecial=introducirNumero();
        System.out.println("Dame la defensa especial del personaje: ");
        defensaSpecial=introducirNumero();
        System.out.println("Dame la velocidad del personaje: ");
        velocidad=introducirNumero();

        return personajeCreado = new Personaje(nombre, liga, vida, ataque, defensa, ataqueSpecial, defensaSpecial, velocidad);
    }

    public static Personaje crearPersonajeSinAtributos () {
        String nombre;
        Liga liga;
        Personaje personajeCreado;
        System.out.println("Dame el nombre del personaje: ");
        nombre=lector.nextLine();
        liga=pedirLiga();

        return personajeCreado= new Personaje (nombre, liga);
    }

    public static void main(String[] args) {

        int opcionSeleccionada;
        Coliseo coliseoCreado;
        Personaje personajeCreado;

        coliseoCreado=crearColiseo();
        
        do{
            opcionSeleccionada=menuPrincipal();
            switch(opcionSeleccionada){
                case 1: {
                    //Modo Individual
                    coliseoCreado.setTipoColiseo(tipoColiseo.INDIVIDUAL);
                    do {
                        opcionSeleccionada=menuBatallaIndividual();
                        switch(opcionSeleccionada){
                            case 1: {
                                do {
                                    opcionSeleccionada=menuPersonaje();
                                    switch(opcionSeleccionada){
                                        case 1: {
                                            personajeCreado=crearPersonajeConAtributos();
                                            coliseoCreado.anadirLuchador(personajeCreado);
                                            pulseIntro();
                                            break;
                                        }
                                        case 2: {
                                            personajeCreado=crearPersonajeSinAtributos();
                                            coliseoCreado.anadirLuchador(personajeCreado);
                                            pulseIntro();
                                            break;
                                        }
                                        default :{
                                            mostrarError(1);
                                        }
                                    }
                                } while (opcionSeleccionada!=3);
                                break;
                            }
                            case 2: {
                                if (coliseoCreado.getNumeroLuchadores()!=0){
                                coliseoCreado.mostrarLuchadores();
                                pulseIntro();
                                }
                                break;
                            }
                            case 3: {
                                //Batallar
                                break;
                            }
                            case 4 : {
                                //Volver al menú principal
                                break;
                            }
                            default : {
                                break;
                            }
                        }

                    } while (opcionSeleccionada!=4);
                    break;
                } 
                
                case 2: {
                    mostrarError(2);
                    break;
                } 
                
                default: {
                    mostrarError(1);
                    break;
                }
            } 
        }while(opcionSeleccionada!=0);
    }
}
