package Modelo;

import java.util.ArrayList;

public class Coliseo {

    public enum tipoColiseo {INDIVIDUAL, MULTIPLE};

    private ArrayList<Personaje> Personajes;
    private String nombreColiseo;
    private tipoColiseo tipoColiseo;
    private int numeroLuchadores;

    public Coliseo(){
        Personajes = new ArrayList<Personaje>();
        numeroLuchadores=0;
    }

    public Coliseo (String nombreColiseo){
        Personajes = new ArrayList<Personaje>();
        this.nombreColiseo=nombreColiseo;
        numeroLuchadores=0;
    }

    public String getNombre(){
        return this.nombreColiseo;
    }

    public void setNombre(String nombreColiseo){
        this.nombreColiseo=nombreColiseo;
    }

    public int getNumeroLuchadores(){
        return this.numeroLuchadores;
    }

    public tipoColiseo getTipoColiseo(){
        return this.tipoColiseo;
    }

    public void setTipoColiseo (tipoColiseo tipoColiseo){
        this.tipoColiseo=tipoColiseo;
    }

    @Override
    public String toString(){
        return this.nombreColiseo + " es de tipo " + this.tipoColiseo + " y tiene un total de " + numeroLuchadores + " luchadores";
    }

    public void anadirLuchador(Personaje personaje){
        Personajes.add(personaje);
        numeroLuchadores++;
    }

    public void mostrarLuchadores(){
        int contador=1;
        for (Personaje personaje: Personajes){
            System.out.println(contador + ".- " + personaje.toString());
            contador++;
        }
    }
    public void mostrarLuchadoresDisponibles(){
        int contador=0;
        for (Personaje personaje: Personajes){
            if(personaje.getLuchadorDisponible()){
            System.out.println(contador + ".- " + "Luchador de nombre: " + personaje.getNombre());
            }
            contador++;
        }
    }

    public Personaje getLuchador(int indice){
        return Personajes.get(indice);
    }

    public void eliminarLuchador (Personaje personaje){
        Personajes.remove(personaje);
        numeroLuchadores--;
    }
    
}
