package Modelo;

public class BatallaMultiple extends Batalla{
    
    Equipos equipoDelTurno;
    Equipos equipoAtacado;

    public BatallaMultiple(){
        super();        
        setTipoBatalla(tipoBatalla.MULTIPLE);
    }

    public BatallaMultiple(Personaje luchadorTurno, Personaje luchadorAtacado, Equipos equipoDelTurno, Equipos equipoAtacado){
        super (luchadorTurno, luchadorAtacado);
        this.equipoDelTurno=equipoDelTurno;
        this.equipoAtacado=equipoAtacado;
        setTipoBatalla(tipoBatalla.MULTIPLE);
    }

    public Equipos getEquipoDelTurno(){
        return this.equipoDelTurno;
    }

    public void setEquipoDelTurno(Equipos equipoDelTurno){
        this.equipoDelTurno=equipoDelTurno;
    }

    public Equipos getEquipoAtacado(){
        return this.equipoAtacado;
    }
    public void setEquipoAtacado(Equipos equipoAtacado){
        this.equipoAtacado=equipoAtacado;
    }

    public void mostrarMenuBatalla(){
        String nombreLuchador = getLuchadorTurno().getNombre().toUpperCase();
        System.out.println("---------------TURNO DE " + nombreLuchador + " -----------------");
        System.out.println("-------------Selecccione una opción----------------");
        System.out.println("- 1.- Ataque --------------------------------------");
        System.out.println("- 2.- Ataque Especial -----------------------------");
        System.out.println("- 3.- Recargar Ataque Especial --------------------");
        System.out.println("- 4.- Mostrar Stats -------------------------------");
        System.out.println("- 5.- Cambiar de Luchador -------------------------");
        System.out.println("---------------------------------------------------");
    }

    public void establecerOrdenDeTurnosPorVelocidad(){
        boolean luchadorTurnoEsMasRapido = compararVelocidadLuchadores();
        if (!luchadorTurnoEsMasRapido){
            alternarLuchadorAtacado();
            alternarEquipoAtacado();
        }
    }
    
    public void alternarEquipoAtacado(){
        Equipos nuevoEquipoAtacante=this.equipoAtacado; //variable auxiliar
        setEquipoAtacado(this.equipoDelTurno);
        setEquipoDelTurno(nuevoEquipoAtacante);
    }

    public boolean sePuedeCambiarLuchador(int index) {
        boolean sePuedeCambiar=false;
        int tamanoEquipo = equipoDelTurno.getTamanoEquipo();
        if (index<tamanoEquipo || index>=0) {
            sePuedeCambiar=true;
        }
        return sePuedeCambiar;
    }

    public boolean estaBatallaMultipleTerminada(){
        boolean batallaTerminada = false;
        boolean equipoAtacadoEsDerrotado=equipoAtacado.comprobarDerrota();
        if (equipoAtacadoEsDerrotado){
            batallaTerminada=true;
        }
        return batallaTerminada;
    }

    public void terminarBatallaMultiple(){
        mostrarGanador();
        resetearTurnos();
    }
}
