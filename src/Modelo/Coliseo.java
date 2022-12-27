package Modelo;

import java.util.ArrayList;

public class Coliseo {

    private ArrayList<Personaje> Personajes;
    private int numeroLuchadores;

    public Coliseo() {
        Personajes = new ArrayList<Personaje>();
        numeroLuchadores=0;
    }

    public int getNumeroLuchadores() {
        return this.numeroLuchadores;
    }

    
    public Personaje getLuchador(int indice) {
        return Personajes.get(indice);
    }

    public void anadirLuchador(Personaje personaje) {
        Personajes.add(personaje);
        numeroLuchadores++;
    }

    public void eliminarLuchador(Personaje personaje) {
        Personajes.remove(personaje);
        numeroLuchadores--;
    }

    public boolean comprobarSiPuedoElegirLuchador (int index) {        
        boolean luchadorExiste = comprobarSiExisteIndexLuchador(index);
        boolean luchadorEstaDisponible = comprobarSiLuchadorEstaDisponible(index);
        boolean puedoElegirLuchador = false;
        if (luchadorExiste && luchadorEstaDisponible) {
            puedoElegirLuchador = true;
        }
        return puedoElegirLuchador;
    }

    public boolean comprobarSiExisteIndexLuchador(int index) {
        int numeroDeLuchadores=getNumeroLuchadores();
        boolean luchadorEstaEnIndex = false;
        if (index<numeroDeLuchadores) {
            luchadorEstaEnIndex = true;
        }
        return luchadorEstaEnIndex;
    }

    public boolean comprobarSiLuchadorEstaDisponible(int index) {
        boolean luchadorDisponible = false;
        boolean luchadorExiste = comprobarSiExisteIndexLuchador(index);
        boolean estaLuchadorDisponible; 
        if (luchadorExiste) {
            estaLuchadorDisponible = getLuchador(index).getLuchadorDisponible();    
            if (estaLuchadorDisponible) {
                luchadorDisponible=true;        
            }
        }
        return luchadorDisponible;
    }

    public void mostrarLuchadores() {
        int contador = 0;
        for (Personaje personaje: Personajes) {
            System.out.println(contador + ".- " + personaje.toString());
            contador++;
        }
    }
    public void mostrarLuchadoresDisponibles() {
        int contador = 0;
        System.out.println("Ahora mismo hay disponibles los siguientes luchadores: ");
        for (Personaje personaje: Personajes) {
            if (personaje.getLuchadorDisponible()) {
            System.out.println(contador + ".- " + "Luchador de nombre: " + personaje.getNombre());
            }
            contador++;
        }
    }
}