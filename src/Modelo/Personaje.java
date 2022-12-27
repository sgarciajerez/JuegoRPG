package Modelo;

public class Personaje {

    public enum Liga {JUSTICIA, TERROR, NEUTRAL, PICARO, JUVENIL};

    private String nombre;
    private Liga Liga;
    private int vida;
    private int ataque;
    private int defensa;
    private int ataqueSpecial;
    private int defensaSpecial;
    private int velocidad;
    //para almacenar los valores que introduce el usuario o que se generan aleatoriamente
    private int vidaOriginal;
    private int ataqueOriginal;
    private int defensaOriginal;
    private int velocidadOriginal;

    private int ataquesDisponibles; //solo un ataque Especial
    private boolean sobrevivir; //solo una Defensa Especial
    private boolean muerto; //para saber si ha muerto o no
    private boolean luchadorDisponible; //variable usada para definir si está disponible para elegir el luchador o no

    public Personaje(){
        this.ataquesDisponibles=1;
        this.sobrevivir=true;
        this.muerto=false;
        this.luchadorDisponible=true;
    }

    public Personaje (String nombre, Liga Liga, int vida, int ataque, int defensa, int ataqueSpecial, int defensaSpecial, int velocidad){
        this.nombre=nombre;
        this.Liga=Liga;
        this.vidaOriginal=vida;
        this.vida=vidaOriginal;
        this.ataqueOriginal=ataque;
        this.ataque=ataqueOriginal;
        this.defensaOriginal=defensa;
        this.defensa=defensaOriginal;
        this.ataqueSpecial=ataqueSpecial;
        this.defensaSpecial=defensaSpecial;
        this.velocidadOriginal=velocidad;
        this.velocidad=velocidadOriginal;
        this.ataquesDisponibles=1;
        this.sobrevivir=true;
        this.muerto=false;
        this.luchadorDisponible=true;
    }

    public Personaje (String nombre, Liga Liga){
        this.nombre=nombre;
        this.Liga=Liga;
        this.vidaOriginal = (int)(Math.random()*50+1);
        this.vida=vidaOriginal;
        this.ataqueOriginal = (int)(Math.random()*50+1);
        this.ataque=ataqueOriginal;
        this.defensaOriginal = (int)(Math.random()*20+1);
        this.defensa=defensaOriginal;        
        this.ataqueSpecial = (int)(Math.random()*50+1);
        this.defensaSpecial = (int)(Math.random()*50+1);
        this.velocidadOriginal = (int)(Math.random()*50+1);
        this.velocidad=velocidadOriginal;
        this.ataquesDisponibles=1;
        this.sobrevivir=true;
        this.muerto=false;
        this.luchadorDisponible=true;
    }

    public String getNombre(){
        return this.nombre;
    }
    public String setNombre(String nombre){
        return this.nombre=nombre;
    }
    public Liga getLiga(){
        return this.Liga;
    }
    public Liga setLiga(Liga Liga){
        return this.Liga=Liga;
    }
    public int getVida(){
        return this.vida;
    }
    public void setVida (int vidaDada){
        this.vidaOriginal=vidaDada;
        this.vida=vidaDada;
    }
    public int getAtaque(){
        return this.ataque;
    }
    public void setAtaque (int ataqueDado){
        this.ataqueOriginal=ataqueDado;
        this.ataque=ataqueDado;
    }
    public int getDefensa(){
        return this.defensa;
    }
    public void setDefensa(int defensaDada){
        this.defensaOriginal=defensaDada;
        this.defensa=defensaDada;
    }
    public int getAtaqueSpecial(){
        return this.ataqueSpecial;
    }
    public int setAtaqueSpecial (int ataqueSpecial){
        return this.ataqueSpecial=ataqueSpecial;
    }
    public int getDefensaSpecial(){
        return this.defensaSpecial;
    }
    public int setDefensaSpecial(int defensaSpecial){
        return this.defensaSpecial=defensaSpecial;
    }
    public int getVelocidad(){
        return this.velocidad;
    }
    public void setVelocidad (int velocidadDada){
        this.velocidadOriginal=velocidadDada;
        this.velocidad=velocidadDada;
    }
    public int getAtaquesEspecialesDisponibles(){
        return this.ataquesDisponibles;
    }
    public boolean getLuchadorDisponible(){
        return this.luchadorDisponible;
    }
    public void setLuchadorDisponible(boolean disponibilidad){
        this.luchadorDisponible=disponibilidad;
    }
    public boolean getMuerte() {
        return this.muerto;
    }

    @Override
    public String toString(){
        return "El personaje "+ this.nombre + " pertenece a la Liga " + this.Liga + " y tiene " + this.vida + " puntos de vida, " + this.ataque + " puntos de ataque, " + this.defensa  + " puntos de defensa, " + this.ataqueSpecial + " puntos de ataque especial, " + this.defensaSpecial + " puntos de defensa especial, " + this.velocidad + " velocidad y " + this.ataquesDisponibles + " ataque(s) especial(es) disponible(s)";
    }

    public void recargarAtaqueSpecial(){
        ataquesDisponibles++;
        System.out.println(this.nombre + " tiene disponibles " + getAtaquesEspecialesDisponibles() + " ataques especiales");
    }

    public void realizarAtaque(Personaje personaje){
        String tipoAtaque="ataque";
        accionDeAtaque(personaje, this.ataque, tipoAtaque);
    }

    public void realizarAtaqueSpecial(Personaje personaje){
        int ataqueSpecial=this.ataque+this.ataqueSpecial;
        String tipoAtaque="ataque especial";
        if (ataquesDisponibles==0){
            System.out.println(this.nombre+ " ha gastado ya sus ataques especiales");
        }else{
            accionDeAtaque(personaje, ataqueSpecial,tipoAtaque);
            this.ataquesDisponibles--;
        }
    }

    private void accionDeAtaque(Personaje personaje, int ataque, String tipoAtaque){
        if (!this.muerto){ //solo se activa si el personaje no ha muerto
        int ataqueRealizado=infoAtaque(personaje, ataque, tipoAtaque);
        ataqueRealizado = quitarAtaqueNegativo(ataqueRealizado);
        int vidaRestante=comprobarVida(ataqueRealizado, personaje); //por si hay que activar defensa Special
        personaje.setVida(vidaRestante);
        personaje.comprobarMuerte(); //para saber si ha muerto o no
        }
    }

    private int infoAtaque (Personaje personaje, int ataque, String tipoAtaque){
        int ataqueAleatorio = (int)(Math.random()*this.ataque+1);
        int ataqueRealizado = ataqueAleatorio - personaje.getDefensa();
        System.out.println("Parece que "+ this.nombre + " va a usar un "+tipoAtaque+ " con un total de " + ataqueAleatorio + " puntos de fuerza");
        System.out.println(personaje.getNombre()+ " antes del ataque tiene " + personaje.getVida() + " puntos de vida");
        System.out.println(personaje.getNombre() + " se defenderá como pueda con " + personaje.getDefensa() + " puntos de defensa");
        return ataqueRealizado;
    }

    private int quitarAtaqueNegativo (int ataqueRealizado){
        if (ataqueRealizado<=0){ //este método se usa para evitar números negativos y que los ataques no sumen vida
        ataqueRealizado=0;
        }
        return ataqueRealizado;
    }

    private int comprobarVida(int ataqueRealizado, Personaje personaje){
        int vidaRestante=personaje.getVida()-ataqueRealizado;
        if (vidaRestante<=0 && sobrevivir){ //la variable sobrevivir hace que solo se pueda invocar la defensa especial una sola vez
            System.out.println("Parece que " + personaje.getNombre() + " se ha visto obligado a usar su Defensa Especial de "+ personaje.getDefensaSpecial()+" puntos para evitar la muerte");
            System.out.println("Ya no dispondrá de más usos de su defensa especial");
            ataqueRealizado-=personaje.getDefensaSpecial();
            ataqueRealizado=quitarAtaqueNegativo(ataqueRealizado);
            vidaRestante = personaje.getVida()-ataqueRealizado;
            sobrevivir=false;
        }
        return vidaRestante;
    }

    private void comprobarMuerte (){
        if (this.vida <=0){
            System.out.println("Vaya, parece que " + this.nombre + " ha muerto");
            muerto=true;
        } else{
            System.out.println("A " +this.nombre + " le quedan " + this.vida + " puntos de vida");
        }
    }

    public void resetearStatsYVidaDelPersonaje() {
        this.vida=vidaOriginal;
        resetearStatsPersonaje();
        System.out.println("Se han resetado las estadísticas de " + this.nombre);
    }
    
    public void resetearStatsPersonaje(){
        this.ataque=ataqueOriginal;
        this.defensa=defensaOriginal;
        this.velocidad=velocidadOriginal;
        this.ataquesDisponibles=1;
        this.luchadorDisponible=true;
    }
}
