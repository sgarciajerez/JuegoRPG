package Modelo;

import Modelo.Personaje.Liga;

public class Batalla {

    public enum tipoBatalla {INDIVIDUAL, MULTIPLE};

    private Personaje luchadorTurno;
    private Personaje luchadorAtacado;
    private tipoBatalla tipoBatalla;
    private int turnos;


    public Batalla(){
        this.turnos=1;
    }

    public Batalla (Personaje luchadorTurno, Personaje luchadorAtacado){
        this.luchadorTurno=luchadorTurno;
        this.luchadorAtacado=luchadorAtacado;
        this.tipoBatalla=tipoBatalla.INDIVIDUAL;
        this.turnos=1;
    }

    public Personaje getLuchadorTurno(){
        return this.luchadorTurno;
    }
    
    public void setLuchadorTurno(Personaje luchadorTurno){
        this.luchadorTurno=luchadorTurno;
    }

    public Personaje getLuchadorAtacado(){
        return this.luchadorAtacado;
    }

    public void setLuchadorAtacado(Personaje luchadorAtacado){
        this.luchadorAtacado=luchadorAtacado;
    }

    public tipoBatalla getTipoBatalla(){
        return this.tipoBatalla;
    }

    public void setTipoBatalla (tipoBatalla tipoBatalla){
        this.tipoBatalla=tipoBatalla;
    }

    public int getTurnos(){
        return this.turnos;
    }
    
    public void setTurnos(int turnos) {
        this.turnos=turnos;
    }

    public void sumarTurno(){
        this.turnos++;
    }

    public void mostrarMenuBatalla(){
        String nombreLuchador = this.luchadorTurno.getNombre().toUpperCase();
        System.out.println("---------------TURNO DE " + nombreLuchador + " ------------------");
        System.out.println("-------------Selecccione una opción----------------");
        System.out.println("- 1.- Ataque --------------------------------------");
        System.out.println("- 2.- Ataque Especial -----------------------------");
        System.out.println("- 3.- Recargar Ataque Especial --------------------");
        System.out.println("- 4.- Mostrar Stats -------------------------------");
        System.out.println("---------------------------------------------------");
    } 

    public void atacar(){
        luchadorTurno.realizarAtaque(luchadorAtacado);
    }
    
    public void atacarEspecial(){
        luchadorTurno.realizarAtaqueSpecial(luchadorAtacado);
    }

    public void recargarAtaqueSpecial(){
        luchadorTurno.recargarAtaqueSpecial();
    }
   
    public void mostrarStatsAtacante () {
        System.out.println(this.luchadorTurno.toString());
    }

    public void establecerOrdenDeTurnosPorVelocidad(){
        boolean luchadorTurnoEsMasRapido = compararVelocidadLuchadores();
        if (!luchadorTurnoEsMasRapido){
            alternarLuchadorAtacado();
        }
    }
    
    public boolean compararVelocidadLuchadores(){
        int velocidadLuchadorTurno=luchadorTurno.getVelocidad();
        int velocidadLuchadorAtacado=luchadorAtacado.getVelocidad();
        boolean esLuchadorTurnoMasRapido=false;
        if (velocidadLuchadorTurno>velocidadLuchadorAtacado){
            esLuchadorTurnoMasRapido=true;
        }
        return esLuchadorTurnoMasRapido;
    }

    public void alternarLuchadorAtacado(){
        Personaje nuevoLuchadorAtacante=this.luchadorAtacado; //variable auxiliar
        setLuchadorAtacado(this.luchadorTurno);
        setLuchadorTurno(nuevoLuchadorAtacante);
    }

    public boolean comprobarSiBatallaTerminada(){
        boolean batallaTerminada=false;
        boolean luchadorAtacadoEstaMuerto=luchadorAtacado.getMuerte();
        if (luchadorAtacadoEstaMuerto){
            batallaTerminada=true;
        }
        return batallaTerminada;
    }
    
    public void terminarBatallaIndividual(){
        mostrarGanador();
        resetearAlGanador();
    }

    protected void mostrarGanador(){
        System.out.println(luchadorTurno.getNombre() + " ha sido el ganador!");
    }

    protected void resetearAlGanador(){
        luchadorTurno.resetearStatsYVidaDelPersonaje();
    }
    
    protected void resetearTurnos() {
        setTurnos(0);
    }

    public void condicionarStatsPorLiga(){
        int puntosPositivos=5;
        int puntosNegativos=-5;
        boolean sonLigasIguales=compararLigaLuchadores();
        if(!sonLigasIguales){
            if (luchadorTurno.getLiga()==Liga.JUSTICIA){
                condicionarAtaquePersonaje(luchadorTurno, puntosNegativos);
                condicionarAtaquePersonaje(luchadorAtacado, puntosPositivos);
                System.out.println(luchadorTurno.getNombre() + " ha perdido ataque y " + luchadorAtacado.getNombre()+ " lo ha ganado debido a que pertenecen a ligas diferentes");
                
            }
            if (luchadorTurno.getLiga()==Liga.TERROR){
                condicionarVelocidadPersonaje(luchadorTurno, puntosPositivos);
                condicionarVelocidadPersonaje(luchadorAtacado, puntosNegativos);
                System.out.println(luchadorTurno.getNombre() + " ha ganado velocidad y " + luchadorAtacado.getNombre()+ " la ha perdido debido a que pertenecen a ligas diferentes");

            }
            if (luchadorTurno.getLiga()==Liga.JUVENIL){
                condicionarDefensaPersonaje(luchadorTurno, puntosNegativos);
                condicionarAtaquePersonaje(luchadorAtacado, puntosNegativos);
                System.out.println(luchadorTurno.getNombre() + " ha perdido defensa y " + luchadorAtacado.getNombre()+ " ha perdido ataque debido a que pertenecen a ligas diferentes");

            }
            if (luchadorTurno.getLiga()==Liga.PICARO){
                condicionarAtaquePersonaje(luchadorTurno, puntosPositivos);
                condicionarVelocidadPersonaje(luchadorAtacado,puntosPositivos);
                System.out.println(luchadorTurno.getNombre() + " ha ganado ataque y " + luchadorAtacado.getNombre()+ " ha ganado velocidad debido a que pertenecen a ligas diferentes");
            }
            if (luchadorTurno.getLiga()==Liga.NEUTRAL){
                condicionarDefensaPersonaje(luchadorTurno, puntosNegativos);
                condicionarAtaquePersonaje(luchadorAtacado, puntosNegativos);
                System.out.println(luchadorTurno.getNombre() + " ha perdido ataque y " + luchadorAtacado.getNombre()+ " ha perdido defensa debido a que pertenecen a ligas diferentes");

            }
        }
    }
    
    public boolean compararLigaLuchadores(){
        boolean ligasIguales=false;
        if (luchadorTurno.getLiga()==luchadorAtacado.getLiga()){
            ligasIguales=true;   
        }
        return ligasIguales;
    }

    private void condicionarAtaquePersonaje(Personaje personaje, int puntosCambiados){
        int ataqueCambiado = personaje.getAtaque()+puntosCambiados;
        personaje.setAtaque(ataqueCambiado);
    }

    private void condicionarDefensaPersonaje(Personaje personaje, int puntosCambiados){
        int defensaCambiada = personaje.getDefensa()+puntosCambiados;
        personaje.setDefensa(defensaCambiada);
    }

    private void condicionarVelocidadPersonaje(Personaje personaje, int puntosCambiados){
        int velocidadCambiada = personaje.getVelocidad()+puntosCambiados;
        personaje.setVelocidad(velocidadCambiada);
    }
}
