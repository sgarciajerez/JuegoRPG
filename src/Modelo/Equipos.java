package Modelo;

import java.util.ArrayList;

public class Equipos {

    private ArrayList <Personaje> equipo;
    private int tamanoEquipo;

    public Equipos(){
        equipo = new ArrayList<Personaje>();
        this.tamanoEquipo=0;
    }

    public int getTamanoEquipo(){
        return this.tamanoEquipo;
    }

    public Personaje getLuchador(int indice){
        return equipo.get(indice);
    }
    
    public void anadirLuchadorEquipo(Personaje personaje){
        equipo.add(personaje);
       this.tamanoEquipo++;
    }
    
    public void eliminarLuchadorDelEquipo(Personaje personaje){
        if (equipo.contains(personaje)) {
        equipo.remove(personaje);
        this.tamanoEquipo--;
        }
    }

    public Personaje devolverUltimoPersonajeAnadido() {
        int ultimoIndex = getTamanoEquipo()-1;
        return equipo.get(ultimoIndex);
    }
    
    public boolean estaElEquipoLleno(Coliseo coliseo) {
        boolean estaElEquipoLleno = false;
        int tamanoMaximoEquipo=calcularTamanoMaximoEquipo(coliseo);
        if (this.tamanoEquipo==tamanoMaximoEquipo){
            estaElEquipoLleno=true;
        }
        return estaElEquipoLleno; 
    }

    public int calcularTamanoMaximoEquipo(Coliseo coliseo) {
        int numeroLuchadoresTotal = coliseo.getNumeroLuchadores();
        int tamanoMaximoEquipo = numeroLuchadoresTotal/2;
        return tamanoMaximoEquipo;
    }
    
    public boolean comprobarDerrota(){
        boolean esDerrotado=false;
        if (equipo.size()==0){
            esDerrotado=true;
        }
        return esDerrotado;
    }

    public void mostrarEquipo(){
        int contador = 0;
        System.out.println("Existen los siguientes luchadores en este equipo: ");
        System.out.println("");
        for(Personaje personaje: equipo){
            System.out.println(contador + ".- " + personaje.toString());
            contador++;
        }
    }
    
    public void resetearSupervivientes() {
        for (Personaje personaje: equipo) {//no hace falta comprobar si los personajes están muertos o no 
            //porque se borran del array equipo cuando mueren
            personaje.resetearStatsYVidaDelPersonaje();
        }
    }
}
