package Modelo;

public class Personaje {

    private String nombre;
    private String Liga;
    private int vida;
    private int ataque;
    private int defensa;
    private int ataqueSpecial;
    private int defensaSpecial;
    private int velocidad;
    private int ataqueDisponible=1; //solo un ataque Especial
    private boolean sobrevivir=true; //solo una Defensa Especial
    private boolean muerto=false; //para saber si ha muerto o no

    public Personaje (String nombre, String Liga, int vida, int ataque, int defensa, int ataqueSpecial, int defensaSpecial, int velocidad){
        this.nombre=nombre;
        this.Liga=Liga;
        this.vida=vida;
        this.ataque=ataque;
        this.defensa=defensa;
        this.ataqueSpecial=ataqueSpecial;
        this.defensaSpecial=defensaSpecial;
        this.velocidad=velocidad;
    }

    public Personaje (String nombre, String Liga){
        this.nombre=nombre;
        this.Liga=Liga;
        this.vida= (int)(Math.random()*50+1);
        this.ataque= (int)(Math.random()*50+1);
        this.defensa= (int)(Math.random()*50+1);        
        this.ataqueSpecial= (int)(Math.random()*50+1);
        this.defensaSpecial=(int)(Math.random()*50+1);
        this.velocidad=(int)(Math.random()*50+1);
    }

    public String getNombre(){
        return this.nombre;
    }
    public String setNombre(String nombre){
        return this.nombre=nombre;
    }
    public String getLiga(){
        return this.Liga;
    }
    public String setLiga(String Liga){
        return this.Liga=Liga;
    }
    public int getVida(){
        return this.vida;
    }
    public int setVida (int vida){
        return this.vida=vida;
    }
    public int getAtaque(){
        return this.ataque;
    }
    public int setAtaque (int ataque){
        return this.ataque=ataque;
    }
    public int getDefensa(){
        return this.defensa;
    }
    public int setDefensa(int defensa){
        return this.defensa=defensa;
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
    public int getVelocidad(){
        return this.velocidad;
    }
    public int setVelocidad (int velocidad){
        return this.velocidad=velocidad;
    }

    //Devuelve true si el personaje que lo invoca es más Rápido que el objetivo
    public boolean compararVelocidad(Personaje personaje){
        boolean masRapido=false;
        if (this.velocidad>personaje.getVelocidad()){
            masRapido=true;
        }
        return masRapido;
    }

    private int muerte(int ataqueRealizado, Personaje personaje){
        int vidaRestante=personaje.getVida()-ataqueRealizado;
        if (vidaRestante<=0 && sobrevivir){ //la variable sobrevivir hace que solo se pueda invocar la defensa especial una sola vez
            System.out.println("Parece que " + personaje.getNombre() + " se ha visto obligado a usar su Defensa Especial de "+ personaje.getDefensaSpecial()+" puntos para evitar la muerte");
            System.out.println("Ya no dispondrá de más usos de su defensa especial");
            ataqueRealizado-=personaje.getDefensaSpecial();
            if (ataqueRealizado<=0){
                ataqueRealizado=0;
            }
            vidaRestante = personaje.getVida()-ataqueRealizado;
            sobrevivir=false;
        }
        return vidaRestante;
    }

    public void ataque(Personaje personaje){
        if(!this.muerto){
            System.out.println(this.nombre + " ataca con una fuerza de " +this.ataque + " puntos");
            System.out.println(personaje.getNombre() + " defiende con " +personaje.getDefensa() + " puntos");
            int ataqueRealizado=this.ataque - personaje.getDefensa();
            if (ataqueRealizado<=0){ //para evitar números negativos y que los ataques no sumen vida
                ataqueRealizado=0;
            }
            int vidaRestante=muerte(ataqueRealizado, personaje);
            personaje.setVida(vidaRestante);
            personaje.comprobarVida();
        }
    }

    public void ataqueSpecial(Personaje personaje){
        if (ataqueDisponible==0){
            System.out.println(this.nombre+ " ha gastado ya sus ataques especiales");
        }else{
            if(!this.muerto){
                System.out.println("Parece que "+ this.nombre + " va a usar un ataque especial con un total de " +this.ataque+this.ataqueSpecial + " puntos de fuerza");
                System.out.println(personaje.getNombre() + " se defenderá como pueda con " +personaje.getDefensa() + " puntos de defensa");
                int ataqueRealizado=(this.ataqueSpecial+this.ataque) - (personaje.getDefensa());
                if (ataqueRealizado<=0){ //para evitar números negativos y que los ataques no sumen vida
                    ataqueRealizado=0;
                }
                int vidaRestante=muerte(ataqueRealizado, personaje);
                personaje.setVida(vidaRestante);
                personaje.comprobarVida();
                this.ataqueDisponible--;
            }
        }
        
    }

    private void comprobarVida (){
        if (this.vida <=0){
            System.out.println("Vaya, parece que " + this.nombre + " ha muerto");
            muerto=true;
        } else{
            System.out.println("A " +this.nombre + " le quedan " + this.vida + " puntos de vida");
        }
    }


}
