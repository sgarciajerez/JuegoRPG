package Controlador;
import java.util.Scanner;

import Modelo.Batalla;
import Modelo.BatallaMultiple;
import Modelo.Coliseo;
import Modelo.Personaje;
import Modelo.Personaje.Liga;
import Modelo.Equipos;

public class Principal {

    public static Scanner lector = new Scanner(System.in);

    public static int menuPrincipal(){
        int opcionSeleccionada;
        limpiarPantalla();
        System.out.println("----------------RPG CAT AVENGERS-------------------");
        System.out.println("-------------Selecccione una opción----------------");
        System.out.println("- 1.- Crear Personaje -----------------------------");
        System.out.println("- 2.- Mostrar Personajes Creados ------------------");
        System.out.println("- 3.- Modo Invidual -------------------------------");
        System.out.println("- 4.- Batallas Grupales ---------------------------");
        System.out.println("- 0.- Salir ---------------------------------------");
        System.out.println("---------------------------------------------------");
        opcionSeleccionada=introducirNumero();
        return opcionSeleccionada;
    }

    public static void crearPersonaje(Coliseo coliseoCreado, int opcionSeleccionada){
        Personaje personajeCreado;
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
                case 3 : {
                    //caso de salida
                    break;
                }
                default :{
                    mostrarError(1);
                }
            }
        } while (opcionSeleccionada!=3);
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

    public static Personaje crearPersonajeConAtributos(){
        String nombre;
        Liga liga;
        Personaje personajeCreado;
        int vida, ataque, defensa, ataqueSpecial, defensaSpecial, velocidad;

        System.out.println("Introduce el nombre del personaje: ");
        nombre=lector.nextLine();
        liga=pedirLiga();
        System.out.println("Introduce la vida del personaje");
        vida=introducirNumero();
        System.out.println("Introduce el ataque del personaje");
        ataque=introducirNumero();
        System.out.println("Introduce la defensa del personaje");
        defensa=introducirNumero();
        System.out.println("Introduce el ataque especial del personaje");
        ataqueSpecial=introducirNumero();
        System.out.println("Introduce la defensa especial del personaje");
        defensaSpecial=introducirNumero();
        System.out.println("Introduce la velocidad del personaje");
        velocidad=introducirNumero();
        personajeCreado = new Personaje(nombre, liga, vida, ataque, defensa, ataqueSpecial, defensaSpecial, velocidad);
        return personajeCreado;
    }

    public static Personaje crearPersonajeSinAtributos() {
        String nombre;
        Liga liga;
        Personaje personajeCreado;
        System.out.println("Introduce el nombre del personaje: ");
        nombre=lector.nextLine();
        liga=pedirLiga();
        personajeCreado= new Personaje (nombre, liga);
        return personajeCreado;
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
                    liga = Liga.JUSTICIA;
                    break;
                }
                case 2 : {
                    liga = Liga.JUVENIL;
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
    
    public static void mostrarLuchadores(Coliseo coliseoCreado){
        int numeroDeLuchadores=coliseoCreado.getNumeroLuchadores();
        if (numeroDeLuchadores!=0){
            coliseoCreado.mostrarLuchadores();
            pulseIntro();
            }
    }

    public static Equipos llenarEquipo(Coliseo coliseo) {
        boolean estaEquipoLleno;
        Personaje luchadorAnadido;
        Equipos equipo = new Equipos();
        System.out.println("VAMOS A CREAR UN NUEVO EQUIPO");

        do{
            estaEquipoLleno=equipo.estaElEquipoLleno(coliseo);
            if (!estaEquipoLleno) {
                luchadorAnadido=elegirLuchador(coliseo);
                equipo.anadirLuchadorEquipo(luchadorAnadido);
            }   
        } while (!estaEquipoLleno);
        limpiarPantalla();
        System.out.println("SE HA CREADO UN NUEVO EQUIPO DE TAMAÑO " + equipo.getTamanoEquipo());
        equipo.mostrarEquipo();
        pulseIntro();
        return equipo;
    }

    public static Personaje elegirLuchador(Coliseo coliseo){
        int index;
        boolean puedoElegirLuchador=false;
        Personaje luchadorElegido;
        do{
            limpiarPantalla();
            coliseo.mostrarLuchadoresDisponibles();
            index=introducirNumero();
            puedoElegirLuchador=coliseo.comprobarSiPuedoElegirLuchador(index);
        } while (!puedoElegirLuchador);
        luchadorElegido=coliseo.getLuchador(index);
        System.out.println("Has elegido como Luchador a " + luchadorElegido.getNombre());
        luchadorElegido.setLuchadorDisponible(false);
        return luchadorElegido;
    }

    public static void realizarAccionIndividual(Batalla batalla){
        boolean turnoFinalizado=false;
        int opcionSeleccionada;
        String mostrarInfoLuchador;

        do {
            limpiarPantalla();
            enfrentarVelocidadLuchadores(batalla);
            batalla.mostrarMenuBatalla();
            opcionSeleccionada=introducirNumero();
            switch(opcionSeleccionada){
                case 1 :{
                    batalla.atacar();
                    turnoFinalizado=true;
                    break;
                }
                case 2: {
                    batalla.atacarEspecial();
                    turnoFinalizado=true;
                    break;
                }
                case 3 : {
                    batalla.recargarAtaqueSpecial();
                    turnoFinalizado=true;
                    break;
                }
                case 4 : {
                    mostrarInfoLuchador=batalla.getLuchadorTurno().toString();
                    System.out.println(mostrarInfoLuchador);
                    break;
                }
                default : {
                    mostrarError(1);
                    break;
                }
            }
            pulseIntro();
        } while (!turnoFinalizado);
    }

    public static void realizarAccionMultiple(BatallaMultiple batalla){
        boolean turnoFinalizado=false;
        int opcionSeleccionada;
        String mostrarInfoLuchador;
        Personaje luchadorCambiado;

        do {
            limpiarPantalla();
            enfrentarVelocidadLuchadores(batalla);
            batalla.mostrarMenuBatalla();
            opcionSeleccionada=introducirNumero();
            switch(opcionSeleccionada){
                case 1 :{
                    batalla.atacar();
                    turnoFinalizado=true;
                    break;
                }
                case 2: {
                    batalla.atacarEspecial();
                    turnoFinalizado=true;
                    break;
                }
                case 3 : {
                    batalla.recargarAtaqueSpecial();
                    turnoFinalizado=true;
                    break;
                }
                case 4 : {
                    mostrarInfoLuchador=batalla.getLuchadorTurno().toString();
                    System.out.println(mostrarInfoLuchador);
                    break;
                }
                case 5 : {
                    System.out.println(batalla.getLuchadorTurno().getNombre());
                    luchadorCambiado=cambiarLuchadorDeEquipo(batalla);
                    batalla.setLuchadorTurno(luchadorCambiado);
                    System.out.println(batalla.getLuchadorTurno().getNombre());
                    System.out.println("Se ha cambiado al luchador por " + batalla.getLuchadorTurno().getNombre());
                    turnoFinalizado=true;
                    break;
                }
                default : {
                    mostrarError(1);
                    break;
                }
            }
            pulseIntro();
        } while (!turnoFinalizado);
    }

    public static Personaje cambiarLuchadorDeEquipo(BatallaMultiple batalla){
        int index;
        boolean sePuedeCambiarLuchador;
        Personaje luchadorCambiado;

        do {
            batalla.getEquipoDelTurno().mostrarEquipo();
            index = introducirNumero();
            sePuedeCambiarLuchador = batalla.sePuedeCambiarLuchador(index);
            if (!sePuedeCambiarLuchador) {
                System.err.println("No se ha encontrado en el equipo el luchador que quieres cambiar, prueba otra vez");
            }
        } while (!sePuedeCambiarLuchador);
        luchadorCambiado=batalla.getEquipoDelTurno().getLuchador(index);
        return luchadorCambiado;
    }
    
    public static void enfrentarVelocidadLuchadores(Batalla batalla){
        if (batalla.getTurnos()==3){ //En el turno 3 ha atacado una vez cada luchador
            //en los requerimientos se pide que se enfrente la velocidad después de que ataque una vez cada luchador
            batalla.establecerOrdenDeTurnosPorVelocidad();
        }
    }

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
        int numeroIntroducido=0;
        System.out.println("Introduce un número válido: ");
        try{
            numeroIntroducido=lector.nextInt();
        }catch(Exception e){
            lector.nextLine(); //limpiamos Buffer
            System.out.println("Ingresa un número por favor: ");
            numeroIntroducido=lector.nextInt();
        }
        lector.nextLine(); //limpiamos Buffer
        return numeroIntroducido;
    }

    public static void mostrarError(int numeroError){
        switch(numeroError){
            case 1 : {
                System.out.println("Introduzca un numero válido por favor");
                break;
            }
            case 2 : {
                System.out.println("Necesitas un número par de luchadores para jugar el modo Batalla Múltiple");
                System.out.println("Prueba a añadir uno más");
                break;
            }
            case 3 : {
                System.out.println("Vaya, parece que no hemos encontrado o ya has usado a ese luchador");
                System.out.println("Prueba otra vez respetando los numeros");
            }
        }
        pulseIntro();
    }

    public static void main(String[] args) {

        int opcionSeleccionada;
        Coliseo coliseoCreado;
        Personaje luchadorTurno;
        Personaje luchadorAtacado;
        boolean estaBatallaTerminada;

        coliseoCreado = new Coliseo();
        
        do{
            opcionSeleccionada=menuPrincipal();
            switch(opcionSeleccionada){
                case 1 : {
                    crearPersonaje(coliseoCreado, opcionSeleccionada);
                    break;
                }
                case 2 : {
                    mostrarLuchadores(coliseoCreado);
                    break;
                }
                case 3: {
                    //Modo Individual
                    Batalla batallaIndividual;
                    boolean alMenosDosLuchadores=coliseoCreado.getNumeroLuchadores()>1;
                    if (alMenosDosLuchadores){
                        luchadorTurno = elegirLuchador(coliseoCreado);
                        luchadorAtacado = elegirLuchador(coliseoCreado);
                        batallaIndividual = new Batalla(luchadorTurno, luchadorAtacado);

                        //Batallar
                        batallaIndividual.condicionarStatsPorLiga();
                        do {
                            realizarAccionIndividual(batallaIndividual);
                            estaBatallaTerminada = batallaIndividual.comprobarSiBatallaTerminada();
                            if (!estaBatallaTerminada){
                                batallaIndividual.alternarLuchadorAtacado();
                                batallaIndividual.sumarTurno();
                            }                   
                        }while(!estaBatallaTerminada);
                        batallaIndividual.terminarBatallaIndividual();
                        pulseIntro();
                    }else {
                        mostrarError(2);
                    }
                }
                case 4: {
                    //Modo por Equipos
                    BatallaMultiple batallaMultiple;

                    boolean sonLuchadoresPar=coliseoCreado.getNumeroLuchadores()%2==0;
                    boolean sonLuchadoresCero=coliseoCreado.getNumeroLuchadores()==0;
                    boolean equipoEsDerrotado;

                    if(sonLuchadoresPar && !sonLuchadoresCero){
                        Equipos equipoDelTurno = llenarEquipo(coliseoCreado);
                        Equipos equipoAtacado = llenarEquipo(coliseoCreado);
                        luchadorTurno = equipoDelTurno.devolverUltimoPersonajeAnadido();
                        luchadorAtacado = equipoAtacado.devolverUltimoPersonajeAnadido();
                        batallaMultiple = new BatallaMultiple(luchadorTurno, luchadorAtacado, equipoDelTurno,equipoAtacado);

                        System.out.println("Empezarán la batalla " + luchadorTurno.getNombre() + " y " + luchadorAtacado.getNombre() + ", que son los ultimos personajes añadidos: ");
                        batallaMultiple.condicionarStatsPorLiga();
                        pulseIntro();

                        do{   
                            System.out.println(batallaMultiple.getEquipoDelTurno().getTamanoEquipo());
                            batallaMultiple.getEquipoDelTurno().mostrarEquipo();                     
                            do {
                                realizarAccionMultiple(batallaMultiple);
                                estaBatallaTerminada = batallaMultiple.comprobarSiBatallaTerminada();
                                if (!estaBatallaTerminada) {
                                    System.out.println("Hola");
                                    pulseIntro();                            
                                    batallaMultiple.alternarLuchadorAtacado();
                                    batallaMultiple.alternarEquipoAtacado();
                                    batallaMultiple.sumarTurno();
                                }
                            } while (!estaBatallaTerminada);

                            luchadorTurno=batallaMultiple.getLuchadorTurno();
                            equipoDelTurno=batallaMultiple.getEquipoDelTurno();
                            luchadorAtacado=batallaMultiple.getLuchadorAtacado();
                            equipoAtacado=batallaMultiple.getEquipoAtacado();
                            batallaMultiple.terminarBatallaMultiple();
                            equipoAtacado.eliminarLuchadorDelEquipo(luchadorAtacado);
                            batallaMultiple.setEquipoAtacado(equipoAtacado);
                            coliseoCreado.eliminarLuchador(luchadorAtacado);
                            equipoEsDerrotado = batallaMultiple.getEquipoAtacado().comprobarDerrota();
                            
                            if (!equipoEsDerrotado) {
                                luchadorTurno.resetearStatsPersonaje();
                                luchadorAtacado=batallaMultiple.getEquipoAtacado().devolverUltimoPersonajeAnadido();
                                System.out.println("Hemos cambiado al luchador muerto por " +  luchadorAtacado.getNombre());
                                System.out.println("Se han reseteado los turnos, por lo que empezará atacando " + luchadorAtacado.getNombre());
                                batallaMultiple.setLuchadorAtacado(luchadorAtacado);
                                batallaMultiple.alternarLuchadorAtacado();
                                batallaMultiple.alternarEquipoAtacado();
                                batallaMultiple.condicionarStatsPorLiga();
                            }
                            pulseIntro();
                        } while (!equipoEsDerrotado);
                        System.out.println("Ha ganado " + luchadorTurno.getNombre() + " y su equipo!");
                        equipoDelTurno.resetearSupervivientes();
                        pulseIntro();                  
                    } 
                    else {
                        mostrarError(3);
                    }
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
